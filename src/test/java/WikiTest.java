import gridmize.Cell;
import gridmize.Grid;
import gridmize.GridBuilder;
import gridmize.GridDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by Eduardo Wermuth on 4/15/17.
 */
public class WikiTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        try {
            // Set your own driver on the GriDriver
            GridDriver.set(new ChromeDriver());
            GridDriver.get().navigate().to("https://en.wikipedia.org/wiki/Comparison_of_GUI_testing_tools");

            /* You need an enum like the one in this example GuiTestingToolsHeader.
            * You can use the GridBuilder to create your instance of Grid, or you can initialize your new grid
            * directly using the Grid constructors.
            * If your page only has one <table> on it, no additional selectors will be needed. Else, you will have
            * to create set a specific selector for it. The same applies for tbody, thead, stc.
            */
            Grid<GuiTestingToolsHeader> wikiGrid = new GridBuilder(GuiTestingToolsHeader.class)
                    .withTableSelector(By.className("wikitable"))
                    .build();

            // Now you can call the grid sending the column you need to do your validations.
            List<Cell<GuiTestingToolsHeader>> column = wikiGrid.getColumn(GuiTestingToolsHeader.NAME);
            for (Cell<GuiTestingToolsHeader> cell : column) {
                String text = cell.getWebElement().getText();
                System.out.println(text);
            }
        } finally {
            GridDriver.get().close();
            GridDriver.get().quit();
        }
    }
}
