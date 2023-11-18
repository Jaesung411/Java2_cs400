public interface IPathOptimizerFrontend
{
    /**
     * Displays the graphical menu, called by main app driver
     */
    public void menu();

    /**
     * Returns the correctly formatted path to the user
     */
    public String path();
}