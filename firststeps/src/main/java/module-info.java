module de.lubowiecki.jfx.firststeps {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;

    opens de.lubowiecki.jfx.firststeps to javafx.fxml;
    exports de.lubowiecki.jfx.firststeps;
}
