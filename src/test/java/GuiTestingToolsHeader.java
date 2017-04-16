import gridmize.HeaderInterface;
import org.openqa.selenium.By;

/**
 * Each item of this Enum is a representation of a header of the grid available here https://en.wikipedia.org/wiki/Comparison_of_GUI_testing_tools
 * <p>
 * The only mandatory field that the enum needs to have populated is the {@code columnIndex}, which needs to be
 * returned by the getColumnIndex method (from the HeaderInterface).<br>
 * The field {@code name} can will be used only if the method Grid.verifyHeaderNames is called.<br>
 * The field {@code actionSelector} needs to be used when you need to click on a button/link/any field that is child
 * of the {@code td} element of the page. An example of usage is on the LICENSE field of this enum.<br>
 * The only thing that changes from the mapping of a grid header like this enum to other headers is the header names,
 * indexes and field names. The constructors will always be the same (in my experience of usage).
 *
 * Created by Eduardo Wermuth on 4/15/17.
 */
public enum GuiTestingToolsHeader implements HeaderInterface {
    NAME(0, "Name"),
    TESTING_SYSTEM(1, "Supported Platform (testing system)"),
    TESTED_SYSTEM(2, "Supported Platform (tested system)"),
    DEVELOPER(3, "Developer"),
    LICENSE(4, "License", By.cssSelector("a")),
    AUTOMATION(5, "Automation"),
    LATEST_VERSION(6, "Latest version"),
    REFERENCE(7, "Reference"),
    STATUS(8, "Status");

    private Integer columnIndex;
    private String columnName;
    private By actionSelector;

    GuiTestingToolsHeader(Integer columnIndex, String columnName) {
        this.columnIndex = columnIndex;
        this.columnName = columnName;
    }

    GuiTestingToolsHeader(Integer columnIndex, String columnName, By actionSelector) {
        this.columnIndex = columnIndex;
        this.columnName = columnName;
        this.actionSelector = actionSelector;
    }

    @Override
    public By getActionSelector() {
        return actionSelector;
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public Integer getColumnIndex() {
        return columnIndex;
    }
}
