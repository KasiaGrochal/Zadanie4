public enum ExpectedInput {

    FIRST_NAME("First Name"), LAST_NAME("Last Name"), SALARY("Salary ");

    private String displayName;

    ExpectedInput(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
