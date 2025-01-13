package view;

import model.UserModel;
import persistence.Role;
import persistence.User;
import model.VehicleModel;
import persistence.Vehicle;
//import persistence.Client;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JPanel pnlMainFrame;
    private JTabbedPane tabMainFrame;
    private JPanel pnlVehicles;
    private JPanel pnlClients;
    private JPanel pnlUsers;
    private JTextField txtBrandSearch;
    private JTextField txtModelSearch;
    private JButton btnSearchVehicle;
    private JTextField txtBrand;
    private JTextField txtModel;
    private JTextField txtCCapacity;
    private JList lstVehicles;
    private JTextField txtFType;
    private JTextField txtCMileage;
    private JTextField txtPerformance;
    private JTextField txtFRegistration;
    private JTextField txtEColor;
    private JTextField txtEWeight;
    private JTextField txtStructure;
    private JLabel lblBrandSearch;
    private JLabel lblModelSearch;
    private JLabel lblBrand;
    private JLabel lblModel;
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
    private JButton btnNewVehicle;
    private JButton btnSaveVehicle;
    private JButton btnDeleteVehicle;
    private JLabel lblUser;
    private JTextField txtDateOfBirth;
    private JTextField txtEmail;
    private JTextField txtLastnameClient;
    private JTextField txtFirstnameClient;
    private JTextField txtStreet;
    private JTextField txtPrivatePhoneNumber;
    private JTextField txtMobilePhoneNumber;
    private JTextField txtPostalCode;
    private JTextField txtPlaceOfResidence;
    private JLabel lblFirstnameClient;
    private JLabel lblLastnameClient;
    private JLabel lblStreet;
    private JLabel lblPostalCode;
    private JLabel lblPlaceOfResidence;
    private JLabel lblPrivatePhoneNumber;
    private JLabel lblMobilePhoneNumber;
    private JLabel lblEmail;
    private JLabel lblDateOfBirth;
    private JPanel pnlButtonsVehicles;
    private JTextField txtFirstnameSearch;
    private JTextField txtLastnameSearch;
    private JList lstClients;
    private JLabel lblFirstnameSearch;
    private JLabel lblLastnameSearch;
    private JButton btnSearchClient;
    private JButton btnNewClient;
    private JButton btnDeleteClient;
    private JButton btnSaveClient;
    private JPanel pnlButtonsClients;
    private JTextField txtUsername;
    private JTextField txtLastnameUser;
    private JTextField txtFirstnameUser;
    private JTextField txtRole;
    private JTextField txtRoleSearch;
    private JTextField txtPassword;
    private JButton btnSearchUser;
    private JList lstUsers;
    private JButton btnNewUser;
    private JButton btnDeleteUser;
    private JButton btnSaveUser;
    private JLabel lblRoleSearch;
    private JLabel lblRole;
    private JLabel lblFirstnameUser;
    private JLabel lblLastnameUser;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private VehicleModel vehicleModel = new VehicleModel();
    //private Client clientModel = new Client();
    private UserModel userModel = new UserModel();

    public MainFrame(User user) {
        super("Vehicle Management");

        setContentPane(pnlMainFrame);
        lblUser.setText(" Welcome " + user.firstname + " " + user.lastname + " (" + user.role + ")");

        switch (user.role) {
            case ADMIN:
                tabMainFrame.removeTabAt(0);
                tabMainFrame.removeTabAt(0);
                showUserList("customer adviser");
                break;

            case VEHICLE_MANAGER:
                tabMainFrame.removeTabAt(1);
                tabMainFrame.removeTabAt(1);
                showVehicleList(null, null);
                break;

            case CUSTOMER_ADVISER:
                tabMainFrame.removeTabAt(2);
                btnDeleteVehicle.setEnabled(false);
                btnNewVehicle.setEnabled(false);
                btnSaveVehicle.setEnabled(false);
                showVehicleList(null, null);
                //showClientList(null, null);
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

    public void showUserList(String role) {
        DefaultListModel<User> listModel = new DefaultListModel<User>();

        for (User user: userModel.getUsers()) {

            if (role != null && user.role.name().equalsIgnoreCase(role) || role == null) {
                listModel.addElement(user);
            }
            lstUsers.setModel(listModel);
        }
    }

    /*public void showClientList(String firstname, String lastname) {
        DefaultListModel<User> listModel = new DefaultListModel<User>();

        boolean mustAddVehicleToTheList = false;
        boolean canAddVehicleToTheList = false;

        for (User user: userModel.getUsers()) {

            if(firstname != null && user.firstname.compareToIgnoreCase(firstname) == 0) {
                canAddVehicleToTheList = true;
            }
            if(lastname != null && user.lastname.compareToIgnoreCase(lastname) == 0) {
                canAddVehicleToTheList = true;
            }
            if(lastname != null && firstname !=null && user.lastname.compareToIgnoreCase(lastname) == 0 && user.firstname.compareToIgnoreCase(firstname) == 0) {
                mustAddVehicleToTheList = true;
                canAddVehicleToTheList = false;
            }
            if(mustAddVehicleToTheList) {
                listModel.removeAllElements();
                listModel.addElement(user);
                break;
            }
            if(canAddVehicleToTheList || lastname == null && firstname ==null) {
                listModel.addElement(user);
                canAddVehicleToTheList = false;
            }
        }
        lstUsers.setModel(listModel);
    }
    */
}
