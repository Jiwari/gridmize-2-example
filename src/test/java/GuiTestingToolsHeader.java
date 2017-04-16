import gridmize.HeaderInterface;
import org.openqa.selenium.By;

/**
 * Created by wermuth on 4/15/17.
 */
public enum GuiTestingToolsHeader implements HeaderInterface {
    NAME(0, "Name"),
    TESTING_SYSTEM(1, "Supported Platform (testing system)"),
    TESTED_SYSTEM(2, "Supported Platform (tested system)"),
    DEVELOPER(3, "Developer"),
    LICENSE(4, "License"),
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
