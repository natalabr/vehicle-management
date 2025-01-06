package view;

import persistence.User;
import model.VehicleModel;
import persistence.Vehicle;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JPanel pnlMainFrame;
    private JTabbedPane tabMainFrame;
    private JPanel pnlVehicles;
    private JPanel pnlClients;
    private JPanel pnlUsers;
    private JTextField txtBrand;
    private JTextField txtModel;
    private JButton btnSearch;
    private JTextField txtBrand2;
    private JTextField txtModel2;
    private JTextField txtCCapacity;
    private JList lstVehicles;
    private JTextField txtFType;
    private JTextField txtCMileage;
    private JTextField txtPerformance;
    private JTextField txtFRegistration;
    private JTextField txtEColor;
    private JTextField txtEWeight;
    private JTextField txtStructure;
    private JLabel lblBrand;
    private JLabel lblModel;
    private JLabel lblBrand2;
    private JLabel lblModel2;
    private JLabel lblCCapacity;
    private JLabel lblFType;
    private JLabel lblCMileage;
    private JLabel lblPerformance;
    private JLabel lblFRegistration;
    private JLabel lblEColor;
    private JLabel lblEWeight;
    private JLabel lblStructure;
    private JLabel lblNSystem;
    private JRadioButton radNSystemYes;
    private JRadioButton radNSystemNo;
    private JButton btnNew;
    private JButton btnSave;
    private JButton btnDelete;
    private JLabel lblUser;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JButton button1;
    private VehicleModel vehicleModel = new VehicleModel();

    public MainFrame(User user) {
        super("Vehicle Management");

        setContentPane(pnlMainFrame);
        lblUser.setText("Welcome " + user.firstname + " " + user.lastname + " (" + user.role + ")");

        switch (user.role) {
            case ADMIN:
                tabMainFrame.removeTabAt(0);
                tabMainFrame.removeTabAt(0);
                break;

            case VEHICLE_MANAGER:
                tabMainFrame.removeTabAt(1);
                tabMainFrame.removeTabAt(1);
                showVehicleList(null, null);
                break;

            case CUSTOMER_ADVISER:
                tabMainFrame.removeTabAt(2);
                btnDelete.setEnabled(false);
                btnNew.setEnabled(false);
                btnSave.setEnabled(false);
                showVehicleList(null, null);
                break;
        }
    }

    private void showVehicleList(String brand, String model) {
        DefaultListModel<Vehicle> listModel = new DefaultListModel<Vehicle>();

        boolean mustAddVehicleToTheList = false;
        boolean canAddVehicleToTheList = false;

        for (Vehicle vehicle: vehicleModel.getVehicles()) {

            if(brand != null && vehicle.brand.compareToIgnoreCase(brand) == 0) {
                canAddVehicleToTheList = true;
            }
            if(model != null && vehicle.model.compareToIgnoreCase(model) == 0) {
                canAddVehicleToTheList = true;
            }
            if(model != null && brand !=null && vehicle.brand.compareToIgnoreCase(brand) == 0 && vehicle.model.compareToIgnoreCase(model) == 0) {
                mustAddVehicleToTheList = true;
                canAddVehicleToTheList = false;
            }
            if(mustAddVehicleToTheList) {
                listModel.removeAllElements();
                listModel.addElement(vehicle);
                break;
            }
            if(canAddVehicleToTheList || model == null && brand ==null) {
                listModel.addElement(vehicle);
                canAddVehicleToTheList = false;
            }
        }
        lstVehicles.setModel(listModel);
    }
}
