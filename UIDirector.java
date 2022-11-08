public class UIDirector {
    private UIBuilder builder;

    public UIDirector(UIBuilder bdr){
        builder = bdr;
    }
    public void build(){
        builder.initialize();
        builder.addUIControls();

    }
}
