class FibNumber{
	int value;
	boolean isEven;
	String result;

	FibNumber(){
		this.value=0;
		this.isEven=false;
		this.result="";
	}

	FibNumber(int value,boolean isEven,String result){
		this.value=value;
		this.isEven=isEven;
		this.result=result;
	}

	int getValue(){
		return this.value;
	}

	void setValue(int value){
		this.value=value;
	}

	boolean getIsEven(){
		return this.isEven;
	}

	void setIsEven(boolean isEven){
		this.isEven=isEven;
	}

	String getResult(){
		return this.result;
	}

	void setResult(String str){
		this.result=str;
	}
}
