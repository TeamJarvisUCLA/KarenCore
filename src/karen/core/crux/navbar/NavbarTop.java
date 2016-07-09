package karen.core.crux.navbar;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import karen.core.crux.session.DataCenter;
import karen.core.crux.session.context.SesionContextHelper;
import karen.core.dialog.generic.data.DialogData;
import karen.core.dialog.generic.enums.DialogActionEnum;
import karen.core.dialog.generic.events.DialogCloseEvent;
import karen.core.dialog.generic.events.listeners.DialogCloseListener;
import karen.core.util.UtilDialog;
import lights.seguridad.consume.services.SesionService;

import org.apache.commons.io.FileUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.event.OpenEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.A;
import org.zkoss.zul.Menu;

public class NavbarTop extends SelectorComposer<Component> {
	
	private static final long serialVersionUID = -2807403689765987268L;
	
	@Wire
	A atask, anoti, amsg;
	
	@Wire
	Menu menuImagen;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		try {
			loadImage();
		} catch (Exception e) {
			UtilDialog.showMessageBoxError("Ha ocurrido un error al cargar la imágen");
		}
	}
	
	private void loadImage() throws Exception {
		try {
			Integer idUser = DataCenter.getUserSecurityData().getUsuario().getIdUsuario();
			
			BufferedImage b = 
					ImageIO.read(new File("/home/tranx6/CAJAFUERTE/Promo54/Imagenes/u_" + idUser));
			
			menuImagen.setImageContent(b);
		} catch (Exception e) {
			BufferedImage b = ImageIO.read(new File("/home/tranx6/CAJAFUERTE/Promo54/Imagenes/default"));
			
			menuImagen.setImageContent(b);
		}
	}

	@Listen("onClick = #lblLogout")
	public void logout() {
		new SesionService().cerrarSesionWeb(DataCenter.getUserSecurityData().getIdSesion());
		
		SesionContextHelper.clear();
		DataCenter.clear();
		
		Executions.sendRedirect("login.zul");
	}
	
	@Listen("onClick = #lblProfile")
	public void profile() {
		DialogData dialogData = new DialogData();

		dialogData.addDialogCloseListeners(new DialogCloseListener() {
			
			@Override
			public void onClose(DialogCloseEvent dialogCloseEvent) {
				if (dialogCloseEvent.getDialogAction().equals(DialogActionEnum.ACEPTAR)) {
					byte[] bytes = (byte[]) dialogCloseEvent.get("bytes");
					
					Integer idUser = DataCenter.getUserSecurityData().getUsuario().getIdUsuario();
					
					if (bytes != null) {
						
						try {
							FileUtils.writeByteArrayToFile(
									new File("/home/tranx6/CAJAFUERTE/Promo54/Imagenes/u_" + idUser), bytes);
						} catch (IOException e) {
							UtilDialog.showMessageBoxError("Ha ocurrido un error al guardar la imágen");
						}
					} else {
						new File("/home/tranx6/CAJAFUERTE/Promo54/Imagenes/u_" + idUser).delete();
					}
					
					try {
						loadImage();
					} catch (Exception e) {
						UtilDialog.showMessageBoxError("Ha ocurrido un error al cargar la imágen");
					}
				}
			}
		});
		
		UtilDialog.showDialog("vista/changeImage.zul", dialogData);
	}
	
	@Listen("onOpen = #taskpp")
	public void toggleTaskPopup(OpenEvent event) {
		toggleOpenClass(event.isOpen(), atask);
	}
	
	@Listen("onOpen = #notipp")
	public void toggleNotiPopup(OpenEvent event) {
		toggleOpenClass(event.isOpen(), anoti);
	}
	
	@Listen("onOpen = #msgpp")
	public void toggleMsgPopup(OpenEvent event) {
		toggleOpenClass(event.isOpen(), amsg);
	}

	// Toggle open class to the component
	public void toggleOpenClass(Boolean open, Component component) {
		HtmlBasedComponent comp = (HtmlBasedComponent) component;
		String scls = comp.getSclass();
		if (open) {
			comp.setSclass(scls + " open");
		} else {
			comp.setSclass(scls.replace(" open", ""));
		}
	}
}
