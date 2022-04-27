module de.lubowiecki.jfx.firststeps {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;

    opens de.lubowiecki.jfx.firststeps;
    opens de.lubowiecki.jfx.firststeps.model;
    exports de.lubowiecki.jfx.firststeps;
}
