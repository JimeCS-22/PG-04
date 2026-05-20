package ucr.algoritmos.pg04algoritmos.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import ucr.algoritmos.pg04algoritmos.model.*;
import ucr.algoritmos.pg04algoritmos.model.Node.*;
import ucr.algoritmos.pg04algoritmos.model.linkedList.CircularDoublyLinkedList;
import ucr.algoritmos.pg04algoritmos.model.linkedList.CircularLinkedList;
import ucr.algoritmos.pg04algoritmos.model.linkedList.DoublyLinkedList;
import ucr.algoritmos.pg04algoritmos.model.linkedList.ListException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Random;

public class MainController {

    @FXML private TabPane mainTabs;

    // TAB: Circular Linked List
    @FXML private TextField textFieldValue;
    @FXML private Button btnAgregarInicio;
    @FXML private Button btnAgregarFinal;
    @FXML private Button btnSearch;
    @FXML private Button btnDelete;
    @FXML private Button btnClearList;
    @FXML private Canvas canvasListDraw;
    @FXML private ListView<String> listViewOperationsList;
    @FXML private TextArea txAreaNodeStructure;
    @FXML private Label txFieldNodeRepre;
    @FXML private Label txtInsertadoIn;
    @FXML
    private TableColumn<Product,Integer> colIdDoubly;
    @FXML
    private TableColumn<CircularNodeData,Integer> colHeadData;
    @FXML
    private TableColumn<CircularNodeData,Integer> colRegDate;
    @FXML
    private TableColumn<CircularNodeData,Integer> colIndexOf;
    @FXML
    private TableColumn<CircularNodeData,Integer> colNombre1;
    @FXML
    private TableColumn<CircularNodeData,Integer> colNextData;
    @FXML
    private TableColumn<CircularNodeData,Integer> colTailData;
    private CircularLinkedList<Integer> list;
    @FXML
    private TableView<CircularNodeData> tableCircularLinkedList;
    private int contadorPosicion;

    //TAB: Circular Doubly Linked List
    @FXML
    private Button btnClearListDoble;
    @FXML
    private Button btnSearchDoble;
    @FXML
    private Canvas canvasListDoubly;
    @FXML
    private Button btnEliminarInicio;
    @FXML
    private TextField txtName;
    @FXML
    private TextArea txAreaNodeStructureD;
    @FXML
    private Label txtInsertar;
    @FXML
    private Button btnAgregarDoble;
    @FXML
    private ListView listViewOperationsListDoubly;
    @FXML
    private TextField txtId;
    @FXML
    private Button btnEliminarDoble;
    @FXML
    private TableColumn<Product,String> colNombre;
    @FXML
    private Button btnEliminarFinal;

    // DoublyLinkedList: estado
    private CircularDoublyLinkedList<Product> doublyList = new CircularDoublyLinkedList<>();
    private final ObservableList<Product> doublyData = FXCollections.observableArrayList();
    private Node<Product> currentProductNode = null;
    private final DateTimeFormatter hireFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @FXML
    private TextArea txAreaNodeRepreDoubly;
    @FXML
    private Button btnSiguiente1;
    @FXML
    private Button btnAgregarDoble11;
    @FXML
    private Button btnAnterior1;
    @FXML
    private TableColumn<Product,Integer> colStock;
    @FXML
    private TableColumn<Integer,Integer> colPositionDoubly1;
    @FXML
    private TableColumn<Product,LocalDate> colFechaIngreso111;
    @FXML
    private Button btnAnterior11;
    @FXML
    private Canvas canvasListDoubly1;
    @FXML
    private Canvas canvasListDoubly11;
    @FXML
    private Label txtInsertadoIn11;
    @FXML
    private TextField txtId11;
    @FXML
    private TableColumn<CircularNodeData,Integer> colPrevData;
    @FXML
    private TextArea txAreaNodeRepreDoubly11;
    @FXML
    private Label txtInsertadoInDoubly;
    @FXML
    private ListView listViewOperationsListDoubly11;
    @FXML
    private TextArea txAreaNodeStructureD1;
    @FXML
    private TextField txtStock;
    @FXML
    private Button btnClearListDoble1;
    @FXML
    private Label txtInsertar1;

    @FXML
    private Label txtInsertadoIn111;
    @FXML
    private Button btnEliminarFinal11;
    @FXML
    private TextField txtPrice;
    @FXML
    private Button btnOrdenarNombre;

    @FXML
    private Button btnSiguiente11;
    @FXML
    private TableColumn colFechaIngreso1111;
    @FXML
    private Button btnClearListDoble11;
    @FXML
    private TableView colID1;
    @FXML
    private TextArea txAreaNodeStructureD11;
    @FXML
    private Button btnAgregarAleatorio;
    @FXML
    private ChoiceBox<String> bxType;
    @FXML
    private TableColumn colPuesto11;
    @FXML
    private TableColumn<CircularNodeData,Integer> colData;
    @FXML
    private TableColumn colFechaIngreso11;
    @FXML
    private Button btnAgregarDoble1;
    @FXML
    private DatePicker dpHireDate11;
    @FXML
    private TableColumn colPuesto1;
    @FXML
    private Button btnEliminarInicio11;
    @FXML
    private TableColumn<Product,String> colType;
    @FXML
    private Button btnEliminarDoble1;
    @FXML
    private Button btnSearchDoble11;
    @FXML
    private Button btnSearchDoble1;
    @FXML
    private Label txtInsertar11;
    @FXML
    private ListView listViewOperationsListDoubly1;
    @FXML
    private DatePicker dpRegisterDate;
    @FXML
    private TextArea txAreaNodeRepreDoubly1;
    @FXML
    private Button btnEliminarFinal1;
    @FXML
    private TableColumn colNombre11;
    @FXML
    private TableColumn<Product,Double> colPrice;
    @FXML
    private Button btnEliminarInicio1;
    @FXML
    private TableColumn colPositionDoubly11;
    @FXML
    private ChoiceBox bxJobPosition11;
    @FXML
    private TableView colID11;
    @FXML
    private TextField txtName11;
    @FXML
    private Button btnEliminarDoble11;
    @FXML
    private TableView<Product> tableCircularDoubly;
    private ObservableList<CircularNodeData> dataTable;//CircularLinkedList
    private ObservableList<Product> dataTableDoubly;//Circular Doubly Linked List
    @FXML
    private Button btnOrdenarStock;

    @FXML
    public void initialize() {
        setupCircularLinkedList();
        setupCircularDoublyLinkedList();
        //setupRandomSearch();
        //setupDoublyLinkedListTab();
    }
    ///Methods Controller for Circular Linked List - Camila
    private void setupCircularLinkedList() {
        list = new CircularLinkedList<>();
        dataTable = FXCollections.observableArrayList();
        contadorPosicion = 0; // atributo en tu Controller

        colIndexOf.setCellValueFactory(new PropertyValueFactory<>("indexOf"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colNextData.setCellValueFactory(new PropertyValueFactory<>("nextData"));
        colPrevData.setCellValueFactory(new PropertyValueFactory<>("prevData"));
        colHeadData.setCellValueFactory(new PropertyValueFactory<>("headData"));
        colTailData.setCellValueFactory(new PropertyValueFactory<>("tailData"));

        tableCircularLinkedList.setItems(dataTable);
        //config botones de operaciones
        btnAgregarInicio.setOnAction(e -> addFirst());
        btnAgregarFinal.setOnAction(e -> addLast());
        btnAgregarAleatorio.setOnAction(e-> addRandom());
        btnSearch.setOnAction(e -> runSearchInLinkedList());
        btnDelete.setOnAction(e -> remove());
        btnClearList.setOnAction(e -> cleanListTab());

    }

    private void addRandom() {

        try {
            int input = new Random().nextInt(50);
            textFieldValue.setText(input+"");
            if (  textFieldValue.getText()==null) {
                showAlert("Error", "Debe ingresar un número positivo");
                return;
            }
            list.addFirst(input);
            String result = list.toString();
            //mostrar la Representación de la lista
            txFieldNodeRepre.setText(result);
            txtInsertadoIn.setText("al inicio: " + input);

            // colocar el registro de operaciones
            registrarOperacion("addFirst", input, "HEAD → [" + input + "] → ...");
            //llenado tabla
            //desplazarPosiciones();
            // agregar fila a la tabla

            actualizarTablaCircular();
            drawLinkedList();//dibujar la acción de addFirst en el Canvas

        } catch (Exception e) {
            showAlert("Error", "Valor inválido");
        }
    }


    private void addFirst() {

        try {
            int input = Integer.parseInt(textFieldValue.getText().trim());

            if (input < 0 || textFieldValue.getText()==null) {
                showAlert("Error", "Debe ingresar un número positivo");
                return;
            }

            list.addFirst(input);
            String result = list.toString();
            //mostrar la Representación de la lista
            txFieldNodeRepre.setText(result);
            txtInsertadoIn.setText("al inicio: " + input);

            // colocar el registro de operaciones
            registrarOperacion("addFirst", input, "HEAD → [" + input + "] → ...");
            //llenado tabla
            //desplazarPosiciones();
            // agregar fila a la tabla

            actualizarTablaCircular();
            drawLinkedList();//dibujar la acción de addFirst en el Canvas

        } catch (Exception e) {
            showAlert("Error", "Valor inválido");
            e.printStackTrace();
        }

    }

    private void addLast() {

            int input = Integer.parseInt(textFieldValue.getText().trim());

            if (input < 0) {
                showAlert("Error", "Debe ingresar un valor");
                return;
            }

            try {
                list.addLast(input);
                txFieldNodeRepre.setText(list.toString());
                txtInsertadoIn.setText("al final: "+input );

                registrarOperacion("addLast", input, "... → [" + input + "] → HEAD");

                contadorPosicion++;

                // agregar fila a la tabla

                actualizarTablaCircular();
                drawLinkedList();

            } catch (Exception e) {
                showAlert("Error", "Valor inválido");
            }

    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void runSearchInLinkedList() {

        int input = Integer.parseInt(textFieldValue.getText().trim());

        // Validación
        if (input < 0 || textFieldValue.getText().isBlank()) {
            showAlert("Error", "Debe ingresar un número positivo");
            return;
        }

        try {
            // Buscar en la lista enlazada
            int posicion = list.indexOf(input);

            if (posicion == -1) {
                // Valor NO encontrado
                txtInsertadoIn.setText("El valor \"" + input + "\" no se encuentra en la lista");
                showAlert("Resultado de búsqueda",
                        "El valor \"" + input + "\" no se encuentra en la lista");

                // registrar operación
                listViewOperationsList.getItems().add(
                        "search(" + input + ") → NO ENCONTRADO"
                );
            } else {
                // Valor encontrado
                txtInsertadoIn.setText("El valor \"" + input + "\" fue encontrado en la posición: " + posicion);
                showAlert("Resultado de búsqueda",
                        "El valor \"" + input + "\" fue encontrado en la posición: " + posicion);

                // registrar operación
                listViewOperationsList.getItems().add(
                        "search(" + input + ") → encontrado en posición " + posicion
                );


                drawLinkedList();
            }

        } catch (Exception e) {
            showAlert("Error", "Error al buscar el valor");
        }

    }

    private void remove() {
        try {
            int input = Integer.parseInt(textFieldValue.getText().trim());

            if (input < 0) {
                showAlert("Error", "Debe ingresar número positivo");
                return;
            }

            //  eliminar de la estructura
            list.remove(input);

            // actualizar representación textual
            txFieldNodeRepre.setText(list.toString());

            // registrar operación
            registrarOperacion("remove", input, "Nodo eliminado");

            dataTable.clear();
            actualizarTablaCircular();
            drawLinkedList();

        } catch (NumberFormatException e) {
            showAlert("Error", "Valor inválido");
        } catch (Exception e) {
            showAlert("Error", "Error al eliminar nodo");
            e.printStackTrace();
        }
    }
    private void cleanListTab() {
        list.clear();
        txFieldNodeRepre.setText("");
        txtInsertadoIn.setText("");
        textFieldValue.setText("");
        listViewOperationsList.getItems().clear();
        tableCircularLinkedList.getItems().clear();
        clearCanvasList();
    }

    private void clearCanvasList() {
        GraphicsContext gc = canvasListDraw.getGraphicsContext2D();
        gc.clearRect(0, 0, canvasListDraw.getWidth(), canvasListDraw.getHeight());
    }
    private void actualizarTablaCircular() throws ListException {
        dataTable.clear();
        if (list.isEmpty()) return;

        Node<Integer> aux = list.getHead();
        Node<Integer> headNode = list.getHead();
        Node<Integer> tailNode = list.getTail();

        int head = headNode.data;
        int tail = tailNode.data;

        int index = 1;

        do {
            int data = aux.data;

            int next = (aux.next != null) ? aux.next.data : -1;

            int prev = list.getPrev(data).data;

            dataTable.add(new CircularNodeData(
                    index,
                    data,
                    next,
                    prev,
                    head,
                    tail
            ));

            aux = aux.next;
            index++;

        } while (aux != headNode);
    }


    private void drawLinkedList() {
        GraphicsContext gc = canvasListDraw.getGraphicsContext2D();
        clearCanvasList();

        double startX = 80;
        double startY = canvasListDraw.getHeight() / 2;
        double nodeWidth = 60;
        double nodeHeight = 40;
        double spacing = 40;

        Color nodeColor = Color.web("#1f2a44");
        Color arrowColor = Color.web("#3b7ddd");

        gc.setFont(Font.font(14));

        // HEAD
        gc.setFill(Color.web("#1f2a44"));
        gc.fillRoundRect(startX - 60, startY - 15, 50, 30, 10, 10);
        gc.setFill(Color.web("#f5a623"));
        gc.fillText("HEAD", startX - 45, startY + 5);

        double currentX = startX;
        Node<Integer> current = list.getHead();
        if (current == null) return;

        do {
            // Nodo
            gc.setFill(nodeColor);
            gc.fillRoundRect(currentX, startY - nodeHeight / 2, nodeWidth, nodeHeight, 10, 10);
            gc.setStroke(Color.WHITE);
            gc.strokeRoundRect(currentX, startY - nodeHeight / 2, nodeWidth, nodeHeight, 10, 10);

            gc.setFill(Color.WHITE);
            gc.fillText(current.getData().toString(), currentX + 20, startY + 5);

            // Flecha normal
            if (current.getNext() != list.getHead()) {
                double arrowStartX = currentX + nodeWidth;
                double arrowEndX = currentX + nodeWidth + spacing;

                gc.setStroke(arrowColor);
                gc.setLineWidth(2);
                gc.strokeLine(arrowStartX, startY, arrowEndX, startY);
                gc.strokeLine(arrowEndX - 5, startY - 5, arrowEndX, startY);
                gc.strokeLine(arrowEndX - 5, startY + 5, arrowEndX, startY);
            }

            // Flecha de retorno al HEAD
            if (current.getNext() == list.getHead()) {
                double arrowStartX = currentX + nodeWidth;
                double arrowEndX = startX - 10; // un poco antes del HEAD
                double arrowTopY = startY - 80;

                gc.setStroke(arrowColor);
                gc.setLineWidth(2);

                // Subir
                gc.strokeLine(arrowStartX, startY, arrowStartX, arrowTopY);
                // Ir hacia la izquierda
                gc.strokeLine(arrowStartX, arrowTopY, arrowEndX, arrowTopY);
                // Bajar hacia el HEAD
                gc.strokeLine(arrowEndX, arrowTopY, arrowEndX, startY - nodeHeight / 2);

                // Punta de flecha (más centrada)
                gc.strokeLine(arrowEndX - 5, startY - nodeHeight / 2 - 5, arrowEndX, startY - nodeHeight / 2);
                gc.strokeLine(arrowEndX - 5, startY - nodeHeight / 2 + 5, arrowEndX, startY - nodeHeight / 2);

            }

            currentX += nodeWidth + spacing;
            current = current.getNext();

        } while (current != list.getHead());
    }



    private void registrarOperacion(String operacion, int valor, String representacion) {
        String texto = operacion + "(" + valor + ")  " + representacion;
        listViewOperationsList.getItems().add(texto);
    }



    // TAB: Circular Doubly Linked List

    private void setupCircularDoublyLinkedList() {

        // ChoiceBox puestos (como en imagen 2)
        bxType.setItems(FXCollections.observableArrayList(
                "Tecnológicos", "Electrónicos", "Hogar", "Belleza",
                "Ropa", "Juguetes"
        ));
        bxType.getSelectionModel().selectFirst();

        dpRegisterDate.setValue(LocalDate.now());


        colIdDoubly.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colRegDate.setCellValueFactory(new PropertyValueFactory<>("registerDate"));

        tableCircularDoubly.setItems(doublyData);

        // Botones
        btnAgregarDoble.setOnAction(e -> addDoubly());
        btnSearchDoble.setOnAction(e -> searchDoubly());
        btnClearListDoble.setOnAction(e -> clearDoublyTab());

        btnOrdenarNombre.setOnAction(e -> orderByName());
        btnOrdenarStock.setOnAction(e -> orderByStock());

        btnEliminarInicio.setOnAction(e -> removeFirstProduct());
        btnEliminarFinal.setOnAction(e -> removeLastEmployee());
        btnEliminarDoble.setOnAction(e -> removeEmployeeById());

    }

    private void orderByName() {
        if (doublyData.isEmpty()) {
            showAlert("Aviso", "No hay productos para ordenar.");
            return;
        }

        // Ordenar por nombre (alfabéticamente)
        FXCollections.sort(doublyData, Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER));

        // Actualizar la tabla
        tableCircularDoubly.refresh();

        // Registrar operación
        listViewOperationsListDoubly.getItems().add("Ordenar por Nombre → completado");
    }
    private void orderByStock() {
        if (doublyData.isEmpty()) {
            showAlert("Aviso", "No hay productos para ordenar.");
            return;
        }

        // Ordenar por stock (de menor a mayor)
        FXCollections.sort(doublyData, Comparator.comparingInt(Product::getStock));

        // Actualizar la tabla
        tableCircularDoubly.refresh();

        // Registrar operación
        listViewOperationsListDoubly.getItems().add("Ordenar por Stock → completado");
    }


    private void addDoubly() {
        int id = Integer.parseInt(txtId.getText() == null ? "" : txtId.getText().trim());
        String name = txtName.getText() == null ? "" : txtName.getText().trim();
        Double price = Double.valueOf(txtPrice.getText() == null ? "" : txtPrice.getText().trim());
        int stock = Integer.parseInt(txtStock.getText() == null ? "" : txtStock.getText().trim());
        String type = (String) bxType.getValue();
        LocalDate registerDate = dpRegisterDate.getValue();

        if (id== 0 || name.isBlank() || price == 0 || stock == 0 || type == null || registerDate ==null ) {
            showAlert("Error", "Debe completar: Id, Name, Price, Stock, Type y Register date.");
            return;
        }

        // Solo letras y espacios
        if (!name.matches("[\\p{L} ]+")) {
            showAlert("Error", "El nombre solo puede contener letras y espacios.");
            txtName.requestFocus();
            return;
        }



        // Que el ID no exista ya en la lista
        if (existsProductId(id)) {
            showAlert("Error", "Ya existe un producto con Id: " + id);
            return;
        }

        Product product = new Product( id, name,price,stock,type,registerDate);
        doublyList.add(product);
        doublyData.add(product);

        currentProductNode = doublyList.getTail();

        listViewOperationsListDoubly.getItems().add("add(" + id + ") HEAD ↔ [Producto ID: " + id + "] ↔ ...");

        refreshDoublyUI("Insertado item: " + id);

        cleanTextFields();
    }

    private void cleanTextFields() {
        txtId.clear();
        txtName.clear();
        txtPrice.clear();
        txtStock.clear();
        bxType.getSelectionModel().selectFirst();

    }

    private boolean existsProductId(int id) {

        try {

            if (doublyList.isEmpty())
                return false;

            Node<Product> aux = doublyList.getHead();

            do {

                if(aux.data != null &&
                        id == aux.data.getId()) {

                    return true;
                }

                aux = aux.next;

            } while(aux != doublyList.getHead());

        } catch (Exception ignored) {}

        return false;
    }

    private void searchDoubly() {
        String id = txtId.getText() == null ? "" : txtId.getText().trim();
        if (id.isBlank()) {
            showAlert("Error", "Digite el Id a buscar.");
            return;
        }

        Node<Product> found = findById(id);
        if (found == null) {
            listViewOperationsListDoubly.getItems().add("search(" + id + ") → NO ENCONTRADO");
            showAlert("Resultado", "No se encontró el producto con Id: " + id);
            return;
        }

        currentProductNode = found;
        listViewOperationsListDoubly.getItems().add("search(" + id + ") → ENCONTRADO");
        refreshDoublyUI("Encontrado: " + id);
        selectProductInTable(found.data);
    }

    private Node<Product> findById(String id) {
        try {

            if(doublyList.isEmpty())
                return null;

            Node<Product> aux = doublyList.getHead();

            do {

                if(aux.data != null &&
                        id.equals(String.valueOf(aux.data.getId()))) {

                    return aux;
                }

                aux = aux.next;

            } while(aux != doublyList.getHead());

        } catch (Exception ignored){}

        return null;
    }


    private void removeFirstProduct() {
        try {
            Product removed = doublyList.removeFirst();
            doublyData.remove(removed);
            listViewOperationsListDoubly.getItems().add("removeFirst() → eliminado ID: " + removed.getId());

            currentProductNode = doublyList.isEmpty() ? null : doublyList.getHead();
            refreshDoublyUI("Eliminado inicio");
        } catch (ListException e) {
            showAlert("Error", e.getMessage());
        }
    }

    private void removeLastEmployee() {
        try {
            Product removed = doublyList.removeLast();
            doublyData.remove(removed);
            listViewOperationsListDoubly.getItems().add("removeLast() → eliminado ID: " + removed.getId());

            currentProductNode = doublyList.isEmpty() ? null : doublyList.getTail();
            refreshDoublyUI("Eliminado final");
        } catch (ListException e) {
            showAlert("Error", e.getMessage());
        }
    }

    private void removeEmployeeById() {
        String id = txtId.getText() == null ? "" : txtId.getText().trim();
        if (id.isBlank()) {
            showAlert("Error", "Digite el Id a eliminar.");
            return;
        }

        Node<Product> found = findById(id);
        if (found == null) {
            showAlert("Resultado", "No existe el Id: " + id);
            return;
        }

        try {
            doublyList.remove(found.data);
            doublyData.remove(found.data);
            listViewOperationsListDoubly.getItems().add("remove(" + id + ") → eliminado");

            currentProductNode = doublyList.isEmpty() ? null : doublyList.getHead();
            refreshDoublyUI("Eliminado: " + id);
        } catch (ListException e) {
            showAlert("Error", e.getMessage());
        }
    }

    private void clearDoublyTab() {
        doublyList.clear();
        doublyData.clear();
        currentProductNode = null;

        txtId.clear();
        txtName.clear();
        dpRegisterDate.setValue(LocalDate.now());
        bxType.getSelectionModel().selectFirst();

        listViewOperationsListDoubly.getItems().clear();
        txAreaNodeRepreDoubly.setText("");
        txtInsertadoInDoubly.setText("");

        clearCanvasDoubly();
    }

    private void refreshDoublyUI(String status) {
        // Representación
        txAreaNodeRepreDoubly.setText(doublyList.toString());

        // Insertad
        txtInsertadoInDoubly.setText(status);

        // dibujar
        drawDoublyList();
    }

    private void selectProductInTable(Product emp) {
        if (emp == null) return;
        tableCircularDoubly.getSelectionModel().select(emp);
        tableCircularDoubly.scrollTo(emp);
    }

    private void clearCanvasDoubly() {
        GraphicsContext gc = canvasListDoubly.getGraphicsContext2D();
        gc.clearRect(0, 0, canvasListDoubly.getWidth(), canvasListDoubly.getHeight());
    }

    private void drawDoublyList() {
        GraphicsContext gc = canvasListDoubly.getGraphicsContext2D();
        gc.setFill(Color.web("#f2f2f2"));
        gc.fillRect(0, 0, canvasListDoubly.getWidth(), canvasListDoubly.getHeight());

        if (doublyList.isEmpty()) return;

        double startX = 80;
        double y = canvasListDoubly.getHeight() / 2.0;
        double nodeW = 90;
        double nodeH = 55;
        double gap = 60;

        Color nodeColor = Color.web("#1f2a44");
        Color arrowColor = Color.web("#f5a623");

        // HEAD
        gc.setFill(nodeColor);
        gc.fillRoundRect(startX - 60, y - 15, 50, 30, 10, 10);
        gc.setFill(Color.web("#f5a623"));
        gc.fillText("HEAD", startX - 45, y + 5);

        Node<Product> aux = doublyList.getHead();
        double x = startX;

        do {
            boolean highlight = (aux == currentProductNode);

            gc.setFill(highlight ? Color.web("#8ef28e") : nodeColor);
            gc.fillRoundRect(x, y - nodeH / 2, nodeW, nodeH, 8, 8);
            gc.setStroke(Color.BLACK);
            gc.strokeRoundRect(x, y - nodeH / 2, nodeW, nodeH, 8, 8);

            gc.setFill(Color.WHITE);
            String text = "⊚: " + (aux.data != null ? aux.data.getName() : 0);
            gc.fillText(text, x + 10, y + 5);

            // Flechas hacia adelante y atrás
            if (aux.next != null) {
                double ax1 = x + nodeW;
                double ax2 = x + nodeW + gap;

                gc.setStroke(arrowColor);
                gc.setLineWidth(2);

                // Flecha hacia adelante
                gc.strokeLine(ax1, y, ax2, y);
                gc.strokeLine(ax2 - 6, y - 6, ax2, y);
                gc.strokeLine(ax2 - 6, y + 6, ax2, y);

                // Flecha hacia atrás (más abajo)
                gc.strokeLine(ax2, y + 15, ax1, y + 15);
                gc.strokeLine(ax1 + 6, y + 15 - 6, ax1, y + 15);
                gc.strokeLine(ax1 + 6, y + 15 + 6, ax1, y + 15);
            }

            x += nodeW + gap;
            aux = aux.next;
        } while (aux != doublyList.getHead());

        // Flecha circular de retorno al HEAD
        double arrowStartX = x - gap;
        double arrowEndX = startX - 10;
        double arrowTopY = y - 90;

        gc.setStroke(arrowColor);
        gc.setLineWidth(2);
        gc.strokeLine(arrowStartX, y, arrowStartX, arrowTopY);
        gc.strokeLine(arrowStartX, arrowTopY, arrowEndX, arrowTopY);
        gc.strokeLine(arrowEndX, arrowTopY, arrowEndX, y - nodeH / 2);

        // Punta de flecha hacia el HEAD
        gc.strokeLine(arrowEndX - 5, y - nodeH / 2 - 5, arrowEndX, y - nodeH / 2);
        gc.strokeLine(arrowEndX - 5, y - nodeH / 2 + 5, arrowEndX, y - nodeH / 2);
    }



}