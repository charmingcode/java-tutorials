package com.mycompany.function;

public enum EnumFunc {
	E1("hello1", 10) {
		@Override
		public String getStatus() {
			return this.status + "E1";
		}
	},
	
	E2("hello2", 11),
	E3("hello3", 12),
	E4("hello4", 13){
	};
	
	private EnumFunc(String s, int i) {
		this.id =i;
		this.status =s;
	}
	
	protected String status;
	private int id;
	
	public String getStatus() {
		return status;
	}
	
	public String toString() {
		return "status=" + getStatus() + ", id=" + this.id;
	}
	
}
