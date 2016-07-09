package karen.core.crux.breadcrums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;

public class Breadcrumbs {

	private List<String> listBreadsCrumbs = new ArrayList<String>();
	
	public Breadcrumbs() {
		super();
	}

	public List<String> getListBreadsCrumbs() {
		return listBreadsCrumbs;
	}

	public void setListBreadsCrumbs(List<String> listBreadsCrumbs) {
		this.listBreadsCrumbs = listBreadsCrumbs;
	}

	public static void updateBreads(List<String> listBreads) {
		Map<String, Object> args = new HashMap<String, Object>();

		args.put("listBreadsCrumbs", listBreads);
		
		BindUtils.postGlobalCommand(null, null, "updateLista", args);
	}
	
	@Command("goHome")
	public void goHome() {
		System.out.println("Go home");
	}
	
	@GlobalCommand
	@NotifyChange({"listBreadsCrumbs", "emptyList", "notEmptyList"})
	public void updateLista(@BindingParam("listBreadsCrumbs") List<String> listBreadsCrumbs) {
		this.listBreadsCrumbs = listBreadsCrumbs;
	}
	
	public boolean getEmptyList() {
		return listBreadsCrumbs.isEmpty();
	}
	
	public boolean getNotEmptyList() {
		return !listBreadsCrumbs.isEmpty();
	}
}
