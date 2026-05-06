module ucr.algoritmos.pg04algoritmos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;


    opens ucr.algoritmos.pg04algoritmos to javafx.fxml;
    opens ucr.algoritmos.pg04algoritmos.model to javafx.base;
    exports ucr.algoritmos.pg04algoritmos;
    exports ucr.algoritmos.pg04algoritmos.controller;
    opens ucr.algoritmos.pg04algoritmos.controller to javafx.fxml;
    exports util;
    opens util to javafx.fxml;
    opens ucr.algoritmos.pg04algoritmos.model.linkedList to javafx.base;
    opens ucr.algoritmos.pg04algoritmos.model.stack to javafx.base;
    opens ucr.algoritmos.pg04algoritmos.model.Queue to javafx.base;
}