package raj.aayush.system.design.callcenter;

class Manager extends Employee {
    public Manager(CallHandler callHandler) {
    	super(callHandler);
    	rank = Rank.Manager;
    }
}
