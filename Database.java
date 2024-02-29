import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<CustInfo> employeeInfos = new ArrayList<>();
    private List<CustInfo> guestInfos = new ArrayList<>();

    public void loadDatabaseFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 9) {
                    CustInfo custInfo = new CustInfo();
                    custInfo.setName(data[1].trim());
                    custInfo.setCarMake(data[2].trim());
                    custInfo.setCarModel(data[3].trim());
                    custInfo.setCarColor(data[4].trim());
                    custInfo.setLicensePlate(data[5].trim());
                    custInfo.setPassExpirationDate(data[6].trim());
                    custInfo.setUsername(data[7].trim());
                    custInfo.setPassword(data[8].trim());

                    int employeeID = 0;
                    try {
                        employeeID = Integer.parseInt(data[0].trim());
                    } catch (NumberFormatException e) {
                        // If it's not a valid employee ID, it will remain 0
                    }

                    if (employeeID != 0) {
                        custInfo.setEmployeeID(employeeID);
                        employeeInfos.add(custInfo);
                    } else {
                        guestInfos.add(custInfo);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<CustInfo> getEmployeeInfos() {
        return employeeInfos;
    }

    public List<CustInfo> getGuestInfos() {
        return guestInfos;
    }

}
