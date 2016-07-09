package karen.core.crux.session.check;

import karen.core.crux.session.DataCenter;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.metainfo.ComponentInfo;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.Window;

public class CheckPerfil extends SelectorComposer<Window> {

	private static final long serialVersionUID = 2886508833829586781L;

	@Override
	public ComponentInfo doBeforeCompose(Page page, Component parent,
			ComponentInfo compInfo) {
		
		if (DataCenter.getUserSecurityData() == null) {
			Executions.sendRedirect("login.zul");
			return null;
		}
		
		if (DataCenter.getPerfil().getIdPerfil() != null) {
			Executions.sendRedirect("index.zul");
			return null;
		}
		
		return super.doBeforeCompose(page, parent, compInfo);
	}

	

}
