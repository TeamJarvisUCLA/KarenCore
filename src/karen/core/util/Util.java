package karen.core.util;

import java.text.SimpleDateFormat;
//import java.util.Map;

//import org.zkoss.zk.ui.Executions;
//
//import luces.delnorte.util.componentes.CaptureOnClose;
//import luces.delnorte.util.controladores.ControladorVentanaDialogo;

public class Util {

	public static String longToStringGenericTimestamp(Long time) {
		if (time == 0L) {
			return "-";
		}
		return new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(time);
	}
	
	public static String longToStringGenericDate(Long time) {
		if (time == 0L) {
			return "-";
		}
		return new SimpleDateFormat("dd/MM/yyyy").format(time);
	}
	
//	public static String toString(Character activo) {
//		return (activo.equals('A')?"Activo":"Inactivo");
//	}
	
//	public static void showDialog(String uri, Map<String, Object> parametros, CaptureOnClose captureOnClose) {
//		ControladorVentanaDialogo genericSimpleCatalogDialog = (ControladorVentanaDialogo) Executions.createComponents(uri, null, parametros);
//		
//		genericSimpleCatalogDialog.setCaptureOnClose(captureOnClose);
//		
//		genericSimpleCatalogDialog.doModal();
//	}
}
