package karen.core.dialog.catalogue.list_pagination.viewmodels;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Init;

import karen.core.dialog.catalogue.list_pagination.controllers.C_ListPaginationCatalogueDialog;
import karen.core.dialog.catalogue.simple_list.viewmodels.VM_SimpleListCatalogueDialog;
import karen.core.listfoot.enums.HowToSeeEnum;
import karen.core.util.payload.UtilPayload;
import lights.core.payload.response.IPayloadResponse;

public abstract class VM_ListPaginationCatalogueDialog<T> extends VM_SimpleListCatalogueDialog<T> {

	@Init(superclass = true)
	public void childInit_VM_ListPaginationCatalogueDialog() {
		//NOTHING OK!
	}
	
	public VM_ListPaginationCatalogueDialog() {
		//NOTHING OK!
	}
	
	@Override
	public List<T> getObjectListToLoad() {
		return null; //INUTILIZADO
	}
	
	public IPayloadResponse<T> updateListBox(Integer page, HowToSeeEnum howToSeeEnum) {
		IPayloadResponse<T> iPayload = getObjectListToLoad(C_ListPaginationCatalogueDialog.CANTIDAD_REGISTROS_PAGINA_DEFECTO, Math.abs(page));
		
		if (!UtilPayload.isOK(iPayload)) {
			return iPayload;
		}
		
		if (howToSeeEnum.equals(HowToSeeEnum.NORMAL)) {
			objectList = iPayload.getObjetos();
			
			selectedObject = null;
		} else {//EXTENDED
			if (objectList == null) {
				objectList = new ArrayList<T>();
			}
			
			if (page == 1) {
				objectList = iPayload.getObjetos();
				
				selectedObject = null;
			} else {
				objectList.addAll(iPayload.getObjetos());
			}
		}
		
		BindUtils.postNotifyChange(null, null, this, "objectList");
		
		return iPayload;
	}

	public abstract IPayloadResponse<T> getObjectListToLoad(Integer cantidadRegistrosPagina, Integer pagina);
}
