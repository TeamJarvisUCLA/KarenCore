package karen.core.wizard.buttons.containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import karen.core.wizard.buttons.data.LiHeaderWizard;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Div;

public class UlHeaderWizard extends Div {

	private static final long serialVersionUID = 6169213044948879943L;
	
	private final String urlUl = "WEB-INF/luces/delnorte/util/vista/ulHeaderWizard.zul";
	
	public void createHeader(List<String> iconos) {
		this.getChildren().clear();
		
		UlHeaderWizard div = new UlHeaderWizard();
		div.setSclass("col s12");
		div.setStyle("text-align: center");
		
		List<LiHeaderWizard> lis = new ArrayList<LiHeaderWizard>();
		
		String width = String.valueOf(100 / iconos.size());
		
		for (int i = 0; i < iconos.size(); i++) {
			String icono = iconos.get(i);
			
			String liStyle = "width: " + width + "% !important";
			
			LiHeaderWizard liHeaderWizard = new LiHeaderWizard(
					liStyle, (i == 0)?"active":"disabled", 
							"", icono);
			
			lis.add(liHeaderWizard);
		}
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("lis", lis);
		
		Div divInner = 
				(Div) Executions.createComponents(urlUl, null, parametros);
		
		div.getChildren().add(divInner);
		
		this.getChildren().add(div);
	}
	
	public void nextIcon() {
		Clients.evalJavaScript(
				"jq('.wizard .nav-tabs li.active').removeClass('active').addClass('disabled').next().removeClass('disabled').addClass('active')");
	}
	
	public void previousIcon() {
		Clients.evalJavaScript(
				"jq('.wizard .nav-tabs li.active').removeClass('active').addClass('disabled').prev().removeClass('disabled').addClass('active')");
	}
}
