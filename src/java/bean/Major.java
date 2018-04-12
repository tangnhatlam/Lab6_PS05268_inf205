package bean;

public class Major {
	private String id;
	private String name;

	public Major() {}
	public Major(String id, String name) {
		this.id = id;
		this.name = name;
	}

    public Major(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}

