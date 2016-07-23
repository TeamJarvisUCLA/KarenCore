package karen.core.crux.session.check;

import karen.core.crux.session.DataCenter;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.metainfo.ComponentInfo;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkmax.zul.Navbar;
import org.zkoss.zkmax.zul.Navitem;
import org.zkoss.zul.A;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

public class CheckIndex extends SelectorComposer<Window> {

	private static final long serialVersionUID = 2886508833829586781L;

	@Wire
	Hlayout main;
	@Wire
	Div sidebar;
	@Wire
	Navbar navbar;
	@Wire
	Navitem calitem;
	@Wire
	A toggler;
	@Wire
	Vlayout vlayout;
	
	@Listen("onClick = #toggler")
	public void toggleSidebarCollapsed() {
		System.out.println("sss");
		if (navbar.isCollapsed()) {
			sidebar.setSclass("side-nav fixed");
			navbar.setCollapsed(false);
			// calitem.setTooltip("calpp, position=end_center, delay=0");
			toggler.setIconSclass("z-icon-angle-double-left");
			vlayout.setSclass("content-main");
		} else {
			sidebar.setSclass("sidebar sidebar-min");
			navbar.setCollapsed(true);
			// calitem.setTooltip("");
			toggler.setIconSclass("z-icon-angle-double-right");
			vlayout.setSclass("content-main-min");
		}

		Clients.resize(sidebar.getRoot().query("#main"));
	}

	@Override
	public ComponentInfo doBeforeCompose(Page page, Component parent,
			ComponentInfo compInfo) {

		if (DataCenter.getUserSecurityData() == null) {
			Executions.sendRedirect("main.zul");
			return null;
		}
		return super.doBeforeCompose(page, parent, compInfo);
	}
}
