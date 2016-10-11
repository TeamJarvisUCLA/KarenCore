package karen.core.listfoot.events;

public class ListFootButtonClickEvent {
	
	private Integer page;
	
	public ListFootButtonClickEvent() {
		super();
	}
	
	public ListFootButtonClickEvent(Integer page) {
		this();
		
		this.page = page;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
}
