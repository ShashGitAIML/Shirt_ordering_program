import java.util.*;
import java.text.DecimalFormat;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Example {

    static final int PROCESSING = 0;
    static final int DELIVERING = 1;
    static final int DELIVERED = 2;

    public static final double xs = 600.00;
    public static final double s = 800.00;
    public static final double m = 900.00;
    public static final double l = 1000.00;
    public static final double xl = 1100.00;
    public static final double xxl = 1200.00;


    public static String[] storeId(String[] orderIds, int nextOrderId) {
        DecimalFormat df = new DecimalFormat("00000");
        orderIds[nextOrderId - 1] = "ODR#" + df.format(nextOrderId);
        return orderIds;
    }

    public static String[] storeContact(String[] contactNumbers, String contact_number, int nextOrderId) {
        contactNumbers[nextOrderId - 1] = contact_number;
        return contactNumbers;
    }

    public static String[] storeSize(String[] sizes, String size, int nextOrderId) {
        sizes[nextOrderId - 1] = size;
        return sizes;
    }

    public static int[] storeQuantity(int[] quantities, int qty, int nextOrderId) {
        quantities[nextOrderId - 1] = qty;
        return quantities;
    }

    public static double[] storeAmount(double[] amounts, double amount, int nextOrderId) {
        amounts[nextOrderId - 1] = amount;
        return amounts;
    }


    public static boolean searchContact(String c_number, String[] user_contact) {
        for (String contact : user_contact) {
            if (c_number.equals(contact)) {
                return true;
            }
        }
        return false;
    }

    public static boolean searchId(String order_id, String[] user_id) {
        for (String Id : user_id) {
            if (order_id.equals(Id)) {
                return true;
            }
        }
        return false;
    }


    public static String[] extendArrayString(String[] ar) {
        String[] temp = new String[ar.length + 1];
        for (int i = 0; i < ar.length; i++) {
            temp[i] = ar[i];
        }
        return temp;
    }

    public static void sortedByAmount(String[] sizes, int[] qty, double[] amount){
        String[] size = {"XS", "S", "M", "L", "XL", "XXL"};
        int[] all_qty = new int[size.length];
        double[] all_amount = new double[size.length];

        for (int j = 0; j < size.length; j++) {
            int total_qty = 0;
            double total_amount = 0;
            for (int i = 0; i < sizes.length; i++) {
                if (sizes[i] != null && size[j].equals(sizes[i])) {
                    total_qty += qty[i];
                    total_amount += amount[i];
                }


            }
            all_qty[j] = total_qty;
            all_amount[j] = total_amount;
        }

        int tem = 0;
        double temd = 0;
        String tems = "";

        for (int j = 0; j < size.length; j++) {
            for (int k = 0; k < size.length - 1; k++) {
                if (all_amount[k] < all_amount[k + 1]) {

                    tem = all_qty[k];
                    all_qty[k] = all_qty[k + 1];
                    all_qty[k + 1] = tem;

                    temd = all_amount[k];
                    all_amount[k] = all_amount[k + 1];
                    all_amount[k + 1] = temd;

                    tems = size[k];
                    size[k] = size[k + 1];
                    size[k + 1] = tems;


                }

            }

        } System.out.println("\t\t+----------+----------+---------------+");
        System.out.printf("\t\t|%-10s|%-10s|%-15s|%n", " Size", " QTY", " Total Amount");
        System.out.println("\t\t+----------+----------+---------------+");

        for (int a = 0; a < size.length; a++) {
            System.out.printf("\t\t|%-10s|%-10d|%-15.2f|%n", size[a], all_qty[a], all_amount[a]);

        }

        System.out.println("\t\t+----------+----------+---------------+");
    }

    public static void sortedByQty(String[] sizes, int[] qty, double[] amount) {
        String[] size = {"XS", "S", "M", "L", "XL", "XXL"};
        int[] all_qty = new int[size.length];
        double[] all_amount = new double[size.length];

        for (int j = 0; j < size.length; j++) {
            int total_qty = 0;
            double total_amount = 0;
            for (int i = 0; i < sizes.length; i++) {
                if (sizes[i] != null && size[j].equals(sizes[i])) {
                    total_qty += qty[i];
                    total_amount += amount[i];
                }
            }
            all_qty[j] = total_qty;
            all_amount[j] = total_amount;
        }

        int tem = 0;
        double temd = 0;
        String tems = "";
        for (int j = 0; j < size.length; j++) {
            for (int k = 0; k < size.length - 1; k++) {

                if (all_qty[k] < all_qty[k + 1]) {

                    tem = all_qty[k];
                    all_qty[k] = all_qty[k + 1];
                    all_qty[k + 1] = tem;

                    temd = all_amount[k];
                    all_amount[k] = all_amount[k + 1];
                    all_amount[k + 1] = temd;

                    tems = size[k];
                    size[k] = size[k + 1];
                    size[k + 1] = tems;


                }
            }
        }
        System.out.println("\t\t+----------+----------+---------------+");
        System.out.printf("\t\t|%-10s|%-10s|%-15s|%n", " Size", " QTY", " Total Amount");
        System.out.println("\t\t+----------+----------+---------------+");

        for (int j = 0; j < size.length; j++) {
            System.out.printf("\t\t|%-10s|%-10d|%-15.2f|%n", size[j], all_qty[j], all_amount[j]);
        }

        System.out.println("\t\t+----------+----------+---------------+");

    }

    public static void allCustomerReports(String[] contactNumbers, String[] sizes, int[] qtys, double[] amounts) {


        String[] customers = new String[0];
        L1:
        for (int i = 0; i < contactNumbers.length; i++) {
            for (int j = 0; j < customers.length; j++) {
                if (contactNumbers[i] == null || contactNumbers[i].equals(customers[j])) {
                    continue L1;
                }
            }
            customers = extendArrayString(customers);
            customers[customers.length - 1] = contactNumbers[i];
        }
        System.out.println("\t\t+---------------+-------+-------+-------+-------+-------+-------+---------------+");
        System.out.printf("\t\t|%-15s|%-7s|%-7s|%-7s|%-7s|%-7s|%-7s|%-15s|%n", " Phone Number", "  XS", "   S", "   M", "   L", "  XL", "  XXL", " Total Amount");
        System.out.println("\t\t+---------------+-------+-------+-------+-------+-------+-------+---------------+");


        for (int i = 0; i < customers.length; i++) {
            int[] tempSizes = new int[6];
            String[] size = {"XS", "S", "M", "L", "XL", "XXL"};

            for (int j = 0; j < contactNumbers.length; j++) {
                if (customers[i].equals(contactNumbers[j])) {
                    switch (sizes[j]) {
                        case "XS":
                            tempSizes[0] += qtys[j];
                            break; //tempSizes[0] = tempSizes[0]+qtys[j]
                        case "S":
                            tempSizes[1] += qtys[j];
                            break; //tempSizes[1] = tempSizes[1]+qtys[j]
                        case "M":
                            tempSizes[2] += qtys[j];
                            break; //tempSizes[2] = tempSizes[2]+qtys[j]
                        case "L":
                            tempSizes[3] += qtys[j];
                            break; //tempSizes[3] = tempSizes[3]+qtys[j]
                        case "XL":
                            tempSizes[4] += qtys[j];
                            break; //tempSizes[4] = tempSizes[4]+qtys[j]
                        case "XXL":
                            tempSizes[5] += qtys[j];
                            break; //tempSizes[5] = tempSizes[5]+qtys[j] //CTRL+D
                    }

                }
            }


            double total = 0;
            for (int j = 0; j < tempSizes.length; j++) {
                total += (double) tempSizes[j] * (size[j].equals("XS") ? xs : size[j].equals("S") ? s : size[j].equals("M") ? m : size[j].equals("L") ? l : size[j].equals("XL") ? xl : xxl);
            }


            System.out.printf("\t\t|%15s|%7s|%7s|%7s|%7s|%7s|%7s|%15s|%n", "", "", "", "", "", "", "", "");
            System.out.printf("\t\t|%-15s|%-7s|%-7s|%-7s|%-7s|%-7s|%-7s|%13.2f  |%n", customers[i], "  " + tempSizes[0], "  " + tempSizes[1], "  " + tempSizes[2], "  " + tempSizes[3], "  " + tempSizes[4], "  " + tempSizes[5], total);

        }
        System.out.println("\t\t+---------------+-------+-------+-------+-------+-------+-------+---------------+");

    }

    public static void viewCustomer(String[] contactNumbers, int[] quantities, double[] amounts) {


        String[] viewCustomers = new String[0];
        L1:
        for (int i = 0; i < contactNumbers.length; i++) {
            for (int j = 0; j < viewCustomers.length; j++) {
                if (contactNumbers[i] == null || contactNumbers[i].equals(viewCustomers[j])) {
                    continue L1;
                }
            }
            viewCustomers = extendArrayString(viewCustomers);
            viewCustomers[viewCustomers.length - 1] = contactNumbers[i];
        }


        int[] all_qty = new int[viewCustomers.length];
        double[] all_amounts = new double[viewCustomers.length];

        L2:
        for (int i = 0; i < viewCustomers.length; i++) {
            int tot_qty = 0;
            double tot_amount = 0;
            for (int j = 0; j < contactNumbers.length; j++) {

                if (contactNumbers[j] != null && viewCustomers[i].equals(contactNumbers[j])) {
                    tot_qty += quantities[j];
                    tot_amount += amounts[j];

                }

            }
            all_qty[i] = tot_qty;
            all_amounts[i] = tot_amount;
        }
        System.out.println("\t\t+----------------+--------------+---------------+");
        System.out.printf("\t\t|%-16s|%-14s|%-15s|%n", " Customer Id ", " All QTY ", " Total Amount");
        System.out.println("\t\t+----------------+--------------+---------------+");

        for (int i = 0; i < viewCustomers.length; i++) {
            System.out.printf("\t\t|%-16s|%-14d|%-15.2f|%n", viewCustomers[i], all_qty[i], all_amounts[i]);
        }
        System.out.println("\t\t+----------------+--------------+---------------+");

    }

    public static void bestInCustomers(String[] contactNumbers, int[] quantities, double[] amounts) {

        String[] bestCustomers = new String[0];
        L1:
        for (int i = 0; i < contactNumbers.length; i++) {
            for (int j = 0; j < bestCustomers.length; j++) {
                if (contactNumbers[i] == null || contactNumbers[i].equals(bestCustomers[j])) {
                    continue L1;
                }
            }
            bestCustomers = extendArrayString(bestCustomers);
            bestCustomers[bestCustomers.length - 1] = contactNumbers[i];
        }


        int[] all_qty = new int[bestCustomers.length];
        double[] all_amounts = new double[bestCustomers.length];

        L2:
        for (int i = 0; i < bestCustomers.length; i++) {
            int tot_qty = 0;
            double tot_amount = 0;
            for (int j = 0; j < contactNumbers.length; j++) {

                if (contactNumbers[j] != null && bestCustomers[i].equals(contactNumbers[j])) {
                    tot_qty += quantities[j];
                    tot_amount += amounts[j];

                }

            }
            all_qty[i] = tot_qty;
            all_amounts[i] = tot_amount;
        }

        int tem = 0;
        double temd = 0;
        String temc = "";
        for (int k = 0; k < bestCustomers.length; k++) {
            for (int i = 0; i < bestCustomers.length - 1; i++) {
                if (all_qty[i] < all_qty[i + 1]) {
                    tem = all_qty[i];
                    all_qty[i] = all_qty[i + 1];
                    all_qty[i + 1] = tem;

                    temd = all_amounts[i];
                    all_amounts[i] = all_amounts[i + 1];
                    all_amounts[i + 1] = temd;

                    temc = bestCustomers[i];
                    bestCustomers[i] = bestCustomers[i + 1];
                    bestCustomers[i + 1] = temc;

                }
            }
        }

        System.out.println("\t\t+----------------+--------------+---------------+");
        System.out.printf("\t\t|%-16s|%-14s|%-15s|%n", " Customer Id ", " All QTY ", " Total Amount");
        System.out.println("\t\t+----------------+--------------+---------------+");

        for (int i = 0; i < bestCustomers.length; i++) {
            System.out.printf("\t\t|%-16s|%-14d|%-15.2f|%n", bestCustomers[i], all_qty[i], all_amounts[i]);
        }
        System.out.println("\t\t+----------------+--------------+---------------+");

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean go_homepage = true;
        String shirt_size = "";
        String contact_number = "";
        int qty = 0;
        double amount = 0;
        String[] sizes = {"XS", "S", "M", "L", "XL", "XXL"};
        double[] prices = {600, 800, 900, 1000, 1100, 1200};
        int nextOrderId = 0;

        String[] orderIds = new String[10000];
        String[] contactNumbers = new String[10000];
        String[] shirt_sizes = new String[10000];
        int[] quantities = new int[10000];
        double[] amounts = new double[10000];

        System.out.println("""
                        
                 /$$$$$$$$                 /$$       /$$                                     /$$                         \s
                | $$_____/                | $$      |__/                                    | $$                         \s
                | $$    /$$$$$$   /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$         /$$$$$$$| $$$$$$$   /$$$$$$   /$$$$$$\s
                | $$$$$|____  $$ /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$       /$$_____/| $$__  $$ /$$__  $$ /$$__  $$
                | $$__/ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$      |  $$$$$$ | $$  \\ $$| $$  \\ $$| $$  \\ $$
                | $$   /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$       \\____  $$| $$  | $$| $$  | $$| $$  | $$
                | $$  |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$       /$$$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/
                |__/   \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/      |_______/ |__/  |__/ \\______/ | $$____/\s
                                                                                                                | $$     \s
                                                                                                                | $$     \s
                                                                                                                |__/     \s
                                                                                                                       \s
                """);

        while (go_homepage) {
            System.out.println("[1] Place order : ");
            System.out.println();
            System.out.println("[2] Search customer : ");
            System.out.println();
            System.out.println("[3] Search order : ");
            System.out.println();
            System.out.println("[4] View reports : ");
            System.out.println();
            System.out.println("[5] Change order status : ");
            System.out.println();
            System.out.print("[6] Delete order : ");
            System.out.println();
            System.out.println();
            System.out.print("Input option : ");
            int num1 = input.nextInt();
            input.nextLine();

            if (num1 == 1) {
                boolean continueOrdering = true;
                while (continueOrdering) {
                    System.out.println();

                    System.out.println("""
                                                        
                              _____   _                      ____            _            \s
                             |  __ \\ | |                    / __ \\          | |           \s
                             | |__) || |  __ _   ___  ___  | |  | | _ __  __| |  ___  _ __\s
                             |  ___/ | | / _` | / __|/ _ \\ | |  | || '__|/ _` | / _ \\| '__|
                             | |     | || (_| || (__|  __/ | |__| || |  | (_| ||  __/| |  \s
                             |_|     |_| \\__,_| \\___|\\___|  \\____/ |_|   \\__,_| \\___||_|  \s
                                                                                          \s
                                                                                          \s
                                                        
                            """);


                    System.out.println();
                    DecimalFormat df = new DecimalFormat("00000");
                    System.out.print("Order Id : ODR#" + df.format(nextOrderId + 1));
                    System.out.println();

                    System.out.print("Enter the customer contact number : ");
                    contact_number = input.next();
                    input.nextLine();

                    // Validate the contact number
                    Pattern pattern = Pattern.compile("^[0]{1}[0-9]{9}$");
                    Matcher matcher = pattern.matcher(contact_number);
                    if (!matcher.matches()) {
                        System.out.println("Invalid phone number...Try again.");
                        System.out.print("Do you want to enter the contact number again? (Y/N) : ");
                        String enter_again = input.nextLine();
                        enter_again = enter_again.toUpperCase();
                        if (enter_again.equals("Y")) {
                            //nextOrderId--;
                            continue;
                        } else {
                            System.out.println("Exiting the program..");

                        }
                    }else{
                        shirt_size = "";
                        boolean validSize = false;
                        while (!validSize) {
                            System.out.print("Enter the T shirt size(XS/S/M/L/XL/XXL) : ");
                            shirt_size = input.nextLine();
                            shirt_size = shirt_size.toUpperCase();

                            for (int i = 0; i < sizes.length; i++) {
                                if (shirt_size.equals(sizes[i])) {
                                    validSize = true;
                                    System.out.println();
                                    System.out.print("Enter the QTY : ");
                                    qty = input.nextInt();
                                    input.nextLine();
                                    amount = prices[i] * qty;
                                    System.out.println();
                                    System.out.print("Amount : " + amount);

                                    System.out.println();
                                    System.out.print("Do you want to place this order(Y/N) : ");
                                    String user_order = input.nextLine();
                                    System.out.println();
                                    System.out.println();
                                    user_order = user_order.toUpperCase();
                                    if (user_order.equals("Y")) {
                                        System.out.println();
                                        nextOrderId += 1;
                                        storeId(orderIds, nextOrderId);
                                        storeContact(contactNumbers, contact_number, nextOrderId);
                                        storeSize(shirt_sizes, shirt_size, nextOrderId);
                                        storeQuantity(quantities, qty, nextOrderId);
                                        storeAmount(amounts, amount, nextOrderId);
                                        System.out.println("Order Placed..!");
                                        System.out.println();

                                        // Order status initially set to PROCESSING
                                        int orderStatus = PROCESSING;

                                        System.out.println();
                                        System.out.print("Do you want to place another order(Y/N) : ");
                                        String another_order = input.nextLine();
                                        another_order = another_order.toUpperCase();
                                        if (another_order.equals("N")) {
                                            continueOrdering = false;

                                        }

                                        //validSize = true;  // Exit the inner loop
                                        break;
                                    }
                                }
                            }

                            if (!validSize) {
                                // Clear any previous input and continue the loop
                                input.nextLine();
                            }
                        }
                    }
                }


            } else if (num1 == 2) {
                System.out.println();
                System.out.println("""
                                                        
                           _____                          _        _____             _                               \s
                          / ____|                        | |      / ____|           | |                              \s
                         | (___    ___   __ _  _ __  ___ | |__   | |     _   _  ___ | |_  ___   _ __ ___    ___  _ __\s
                          \\___ \\  / _ \\ / _` || '__|/ __|| '_ \\  | |    | | | |/ __|| __|/ _ \\ | '_ ` _ \\  / _ \\| '__|
                          ____) ||  __/| (_| || |  | (__ | | | | | |____| |_| |\\__ \\| |_| (_) || | | | | ||  __/| |  \s
                         |_____/  \\___| \\__,_||_|   \\___||_| |_|  \\_____|\\__,_||___/ \\__|\\___/ |_| |_| |_| \\___||_|  \s
                                                                                                                     \s
                                                                                                                     \s
                                                        
                        """);
                System.out.println();
                if (nextOrderId > 0) {
                    boolean anotherCustomer = false;
                    while (!anotherCustomer) {
                        double total = 0;
                        String[] user_contact = new String[storeContact(contactNumbers, contact_number, nextOrderId).length];
                        String[] user_size = new String[storeSize(shirt_sizes, shirt_size, nextOrderId).length];
                        int[] shirt_quantity = new int[storeQuantity(quantities, qty, nextOrderId).length];
                        double[] price_amount = new double[storeAmount(amounts, amount, nextOrderId).length];
                        for (int i = 0; i < nextOrderId; i++) {
                            user_contact[i] = storeContact(contactNumbers, contact_number, nextOrderId)[i];
                            user_size[i] = storeSize(shirt_sizes, shirt_size, nextOrderId)[i];
                            shirt_quantity[i] = storeQuantity(quantities, qty, nextOrderId)[i];
                            price_amount[i] = storeAmount(amounts, amount, nextOrderId)[i];
                        }

                        System.out.print("Enter the customer contact number : ");
                        String c_number = input.nextLine();
                        System.out.println();
                        boolean isCustomerAvailable = searchContact(c_number, user_contact);
                        if (isCustomerAvailable) {
                            System.out.println();
                            System.out.println();
                            System.out.println("\t\t+----------+---------------+---------------+");
                            System.out.printf("\t\t|%-10s|%-15s|%-15s|%n", " Size", "  Quantity", " Amount");
                            System.out.println("\t\t+----------+---------------+---------------+");


                            for (int i = 0; i < nextOrderId; i++) {
                                if (c_number.equals(user_contact[i])) {
                                    total += price_amount[i];
                                    System.out.printf("\t\t|%-10s|%-15d|%-15.2f|%n", user_size[i], shirt_quantity[i], price_amount[i]);


                                }
                            }
                            System.out.println("\t\t+--------------------------+---------------+");
                            System.out.printf("\t\t|%-26s|%-15.2f|%n", "   Total amount  ", total);
                            System.out.println("\t\t+--------------------------+---------------+");

                            System.out.println();
                            System.out.println();
                        } else {
                            System.out.println("Customer contact number is not available..!");
                        }
                        System.out.print("Do you want to search another customer report(Y/N) : ");
                        String another_customer = input.nextLine();
                        another_customer = another_customer.toUpperCase();
                        if (another_customer.equals("Y")) {
                            anotherCustomer = true;

                        } else {
                            break;
                        }
                    }
                } else {
                    System.out.println("There are no previous orders.");
                }

            } else if (num1 == 3) {
                System.out.println();
                System.out.println("""
                                                
                           _____                          _        ____            _            \s
                          / ____|                        | |      / __ \\          | |           \s
                         | (___    ___   __ _  _ __  ___ | |__   | |  | | _ __  __| |  ___  _ __\s
                          \\___ \\  / _ \\ / _` || '__|/ __|| '_ \\  | |  | || '__|/ _` | / _ \\| '__|
                          ____) ||  __/| (_| || |  | (__ | | | | | |__| || |  | (_| ||  __/| |  \s
                         |_____/  \\___| \\__,_||_|   \\___||_| |_|  \\____/ |_|   \\__,_| \\___||_|  \s
                                                                                                \s
                                                                                                \s
                                                
                        """);
                System.out.println();
                if (nextOrderId > 0) {
                    boolean continueOrdering = true;
                    boolean validOrderId = false;
                    while (continueOrdering) {
                        String[] user_id = new String[storeId(orderIds, nextOrderId).length];
                        String[] user_contact = new String[storeContact(contactNumbers, contact_number, nextOrderId).length];
                        String[] user_size = new String[storeSize(shirt_sizes, shirt_size, nextOrderId).length];
                        int[] shirt_quantity = new int[storeQuantity(quantities, qty, nextOrderId).length];
                        double[] price_amount = new double[storeAmount(amounts, amount, nextOrderId).length];
                        for (int i = 0; i < nextOrderId; i++) {
                            user_id[i] = storeId(orderIds, nextOrderId)[i];
                            user_contact[i] = storeContact(contactNumbers, contact_number, nextOrderId)[i];
                            user_size[i] = storeSize(shirt_sizes, shirt_size, nextOrderId)[i];
                            shirt_quantity[i] = storeQuantity(quantities, qty, nextOrderId)[i];
                            price_amount[i] = storeAmount(amounts, amount, nextOrderId)[i];
                        }


                        // Input and validate order ID
                        while (!validOrderId) {
                            System.out.print("Enter the order ID (ODR#xxxxx): ");
                            String order_id = input.nextLine();
                            int idNumber = Integer.parseInt(order_id.substring(5));
                            if (order_id.matches("^ODR#[0-9]{5}$") && idNumber >= 1 && idNumber <= 10000) {
                                validOrderId = true;

                                // Store the order ID in the array or process it as needed
                                boolean isIdAvailable = searchId(order_id, user_id);
                                if (isIdAvailable) {
                                    for (int i = 0; i < nextOrderId; i++) {
                                        if (order_id.equals(storeId(orderIds, nextOrderId)[i])) {
                                            System.out.println("Phone number : " + user_contact[i]);
                                            System.out.println("Size         : " + user_size[i]);
                                            System.out.println("QTY          : " + shirt_quantity[i]);
                                            System.out.println("Amount       : " + price_amount[i]);
                                            System.out.println();
                                        }
                                    }

                                } else {
                                    System.out.println("Invalid ID..");
                                    break;
                                }
                            } else {
                                System.out.println("Invalid ID..");
                                validOrderId = true;
                                break;
                            }

                            System.out.print("Do you want to search another order(Y/N) : ");
                            String search_again = input.nextLine();
                            System.out.println();
                            search_again = search_again.toUpperCase();
                            if (search_again.equals("Y")) {
                                validOrderId = false;
                                break;
                            } else {
                                continueOrdering = false;
                                break;
                            }

                        }
                    }
                } else {
                    System.out.println("There are no previous orders.");
                }

            } else if (num1 == 4) {
                boolean go_mainmenu = false;
                System.out.println();
                System.out.println("""
                                                
                          _____                            _       \s
                         |  __ \\                          | |      \s
                         | |__) | ___  _ __    ___   _ __ | |_  ___\s
                         |  _  / / _ \\| '_ \\  / _ \\ | '__|| __|/ __|
                         | | \\ \\|  __/| |_) || (_) || |   | |_ \\__ \\
                         |_|  \\_\\\\___|| .__/  \\___/ |_|    \\__||___/
                                      | |                          \s
                                      |_|                          \s
                                                
                        """);
                System.out.println();
                while (!go_mainmenu) {

                    System.out.println("[1] Customer Reports");
                    System.out.println("[2] Item Reports");
                    System.out.println("[3] Order Reports");
                    System.out.print("Enter the option ");
                    int num2 = input.nextInt();

                    if (num2 == 1) {
                        System.out.println();
                        System.out.println("""
                                                            
                                   _____             _                                  _____                            _       \s
                                  / ____|           | |                                |  __ \\                          | |      \s
                                 | |     _   _  ___ | |_  ___   _ __ ___    ___  _ __  | |__) | ___  _ __    ___   _ __ | |_  ___\s
                                 | |    | | | |/ __|| __|/ _ \\ | '_ ` _ \\  / _ \\| '__| |  _  / / _ \\| '_ \\  / _ \\ | '__|| __|/ __|
                                 | |____| |_| |\\__ \\| |_| (_) || | | | | ||  __/| |    | | \\ \\|  __/| |_) || (_) || |   | |_ \\__ \\
                                  \\_____|\\__,_||___/ \\__|\\___/ |_| |_| |_| \\___||_|    |_|  \\_\\\\___|| .__/  \\___/ |_|    \\__||___/
                                                                                                    | |                          \s
                                                                                                    |_|                          \s
                                                            
                                """);
                        System.out.println();


                        System.out.println();
                        System.out.println();
                        System.out.println("[1] Best in customers");
                        System.out.println("[2] View customers");
                        System.out.println("[3] All customer reports");
                        System.out.println();
                        System.out.println();
                        System.out.print("Enter the option ");
                        int num3 = input.nextInt();

                        if (num3 == 1) {
                            System.out.println();
                            System.out.println("""
                                                                    
                                      ____              _     _                            _                                    \s
                                     |  _ \\            | |   (_)                          | |                                   \s
                                     | |_) |  ___  ___ | |_   _  _ __     ___  _   _  ___ | |_  ___   _ __ ___    ___  _ __  ___\s
                                     |  _ <  / _ \\/ __|| __| | || '_ \\   / __|| | | |/ __|| __|/ _ \\ | '_ ` _ \\  / _ \\| '__|/ __|
                                     | |_) ||  __/\\__ \\| |_  | || | | | | (__ | |_| |\\__ \\| |_| (_) || | | | | ||  __/| |   \\__ \\
                                     |____/  \\___||___/ \\__| |_||_| |_|  \\___| \\__,_||___/ \\__|\\___/ |_| |_| |_| \\___||_|   |___/
                                                                                                                                \s
                                                                                                                                \s
                                                                    
                                    """);
                            System.out.println();

                            String[] user_contact = new String[storeContact(contactNumbers, contact_number, nextOrderId).length];
                            int[] shirt_quantity = new int[storeQuantity(quantities, qty, nextOrderId).length];
                            double[] price_amount = new double[storeAmount(amounts, amount, nextOrderId).length];

                            for (int i = 0; i < nextOrderId; i++) {

                                user_contact[i] = storeContact(contactNumbers, contact_number, nextOrderId)[i];
                                shirt_quantity[i] = storeQuantity(quantities, qty, nextOrderId)[i];
                                price_amount[i] = storeAmount(amounts, amount, nextOrderId)[i];
                            }
                            System.out.println();
                            bestInCustomers(user_contact, shirt_quantity, price_amount);
                            System.out.print("To access the Main menu, please enter 0 : ");
                            int go_main = input.nextInt();
                            System.out.println();
                            System.out.println();
                            if (go_main == 0) {
                                go_mainmenu = true;
                            }

                        } else if (num3 == 2) {
                            System.out.println();
                            System.out.println("""
                                                                    
                                     __      __ _                    _____             _                                    \s
                                     \\ \\    / /(_)                  / ____|           | |                                   \s
                                      \\ \\  / /  _   ___ __      __ | |     _   _  ___ | |_  ___   _ __ ___    ___  _ __  ___\s
                                       \\ \\/ /  | | / _ \\\\ \\ /\\ / / | |    | | | |/ __|| __|/ _ \\ | '_ ` _ \\  / _ \\| '__|/ __|
                                        \\  /   | ||  __/ \\ V  V /  | |____| |_| |\\__ \\| |_| (_) || | | | | ||  __/| |   \\__ \\
                                         \\/    |_| \\___|  \\_/\\_/    \\_____|\\__,_||___/ \\__|\\___/ |_| |_| |_| \\___||_|   |___/
                                                                                                                            \s
                                                                                                                            \s
                                                                    
                                    """);
                            System.out.println();

                            String[] user_contact = new String[storeContact(contactNumbers, contact_number, nextOrderId).length];
                            int[] shirt_quantity = new int[storeQuantity(quantities, qty, nextOrderId).length];
                            double[] price_amount = new double[storeAmount(amounts, amount, nextOrderId).length];

                            for (int i = 0; i < nextOrderId; i++) {

                                user_contact[i] = storeContact(contactNumbers, contact_number, nextOrderId)[i];
                                shirt_quantity[i] = storeQuantity(quantities, qty, nextOrderId)[i];
                                price_amount[i] = storeAmount(amounts, amount, nextOrderId)[i];
                            }
                            System.out.println();
                            viewCustomer(user_contact, shirt_quantity, price_amount);
                            System.out.print("To access the Main menu, please enter 0 : ");
                            int go_main = input.nextInt();
                            System.out.println();
                            System.out.println();
                            if (go_main == 0) {
                                go_mainmenu = true;
                            }

                        } else if (num3 == 3) {

                            System.out.println();
                            System.out.println("""
                                                    
                                               _ _    _____          _                              _____                       _      \s
                                         /\\   | | |  / ____|        | |                            |  __ \\                     | |     \s
                                        /  \\  | | | | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___\s
                                       / /\\ \\ | | | | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|
                                      / ____ \\| | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\
                                     /_/    \\_\\_|_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/
                                                                                                              | |                      \s
                                                                                                              |_|                      \s
                                                    
                                    """);
                            System.out.println();


                            String[] user_contact = new String[storeContact(contactNumbers, contact_number, nextOrderId).length];
                            String[] user_size = new String[storeSize(shirt_sizes, shirt_size, nextOrderId).length];
                            int[] shirt_quantity = new int[storeQuantity(quantities, qty, nextOrderId).length];
                            double[] price_amount = new double[storeAmount(amounts, amount, nextOrderId).length];

                            for (int i = 0; i < nextOrderId; i++) {
                                user_contact[i] = storeContact(contactNumbers, contact_number, nextOrderId)[i];
                                shirt_quantity[i] = storeQuantity(quantities, qty, nextOrderId)[i];
                                user_size[i] = storeSize(shirt_sizes, shirt_size, nextOrderId)[i];
                                price_amount[i] = storeAmount(amounts, amount, nextOrderId)[i];
                            }

                            System.out.println();
                            allCustomerReports(user_contact, user_size, shirt_quantity, price_amount);
                            System.out.print("To access the Main menu, please enter 0 : ");
                            int go_main = input.nextInt();
                            System.out.println();
                            System.out.println();
                            if (go_main == 0) {
                                go_mainmenu = true;
                            }

                        }
                    } else if (num2 == 2) {
                        System.out.println();
                        System.out.println("""
                                                           
                                 _____ _                   _____                       _      \s
                                |_   _| |                 |  __ \\                     | |     \s
                                  | | | |_ ___ _ __ ___   | |__) |___ _ __   ___  _ __| |_ ___\s
                                  | | | __/ _ \\ '_ ` _ \\  |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|
                                 _| |_| ||  __/ | | | | | | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\
                                |_____|\\__\\___|_| |_| |_| |_|  \\_\\___| .__/ \\___/|_|   \\__|___/
                                                                     | |                      \s
                                                                     |_|                      \s
                                                            
                                """);
                        System.out.println();
                        System.out.println();
                        System.out.println("[1] Best selling categories sorted by Qty.");
                        System.out.println("[2] Best selling categories sorted by Amount.");
                        System.out.print("Enter the option : ");
                        int option = input.nextInt();
                        if (option == 1) {
                            String[] user_size = new String[storeSize(shirt_sizes, shirt_size, nextOrderId).length];
                            int[] shirt_quantity = new int[storeQuantity(quantities, qty, nextOrderId).length];
                            double[] price_amount = new double[storeAmount(amounts, amount, nextOrderId).length];

                            user_size = storeSize(shirt_sizes, shirt_size, nextOrderId);
                            shirt_quantity = storeQuantity(quantities, qty, nextOrderId);
                            price_amount = storeAmount(amounts, amount, nextOrderId);

                            sortedByQty(user_size, shirt_quantity, price_amount);
                            System.out.print("To access the Main menu, please enter 0 : ");
                            int go_main = input.nextInt();
                            System.out.println();
                            System.out.println();
                            if (go_main == 0) {
                                go_mainmenu = true;
                            }
                        } else if (option == 2) {
                            System.out.println();
                            System.out.println("""
                                                                    
                                       _____            _           _   ____                                               _      \s
                                      / ____|          | |         | | |  _ \\            /\\                               | |     \s
                                     | (___   ___  _ __| |_ ___  __| | | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ ___\s
                                      \\___ \\ / _ \\| '__| __/ _ \\/ _` | |  _ <| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __/ __|
                                      ____) | (_) | |  | ||  __/ (_| | | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_\\__ \\
                                     |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|___/
                                                                               __/ |                                              \s
                                                                              |___/                                               \s
                                                                     
                                    """);
                            System.out.println();

                            String[] user_size = new String[storeSize(shirt_sizes, shirt_size, nextOrderId).length];
                            int[] shirt_quantity = new int[storeQuantity(quantities, qty, nextOrderId).length];
                            double[] price_amount = new double[storeAmount(amounts, amount, nextOrderId).length];

                            user_size = storeSize(shirt_sizes, shirt_size, nextOrderId);
                            shirt_quantity = storeQuantity(quantities, qty, nextOrderId);
                            price_amount = storeAmount(amounts, amount, nextOrderId);

                            sortedByAmount(user_size, shirt_quantity, price_amount);
                            System.out.print("To access the Main menu, please enter 0 : ");
                            int go_main = input.nextInt();
                            System.out.println();
                            System.out.println();
                            if (go_main == 0) {
                                go_mainmenu = true;
                            }

                        }
                    }else if(num2 == 3){
                        System.out.println();
                        System.out.println("""
                                                                
                                   ____          _             _____                       _      \s
                                  / __ \\        | |           |  __ \\                     | |     \s
                                 | |  | |_ __ __| | ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___\s
                                 | |  | | '__/ _` |/ _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|
                                 | |__| | | | (_| |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\
                                  \\____/|_|  \\__,_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/
                                                                         | |                      \s
                                                                         |_|                      \s
                                                                
                                """);
                        System.out.println();
                        System.out.println();
                        System.out.println("[1] All orders.");
                        System.out.println("[2] Orders by amount.");
                        System.out.println("Enter the option : ");
                        int another_option = input.nextInt();
                        if(another_option == 1){
                            System.out.println();
                            System.out.println("""
                                                                        
                                     __      ___                  ____          _              \s
                                     \\ \\    / (_)                / __ \\        | |             \s
                                      \\ \\  / / _  _____      __ | |  | |_ __ __| | ___ _ __ ___\s
                                       \\ \\/ / | |/ _ \\ \\ /\\ / / | |  | | '__/ _` |/ _ \\ '__/ __|
                                        \\  /  | |  __/\\ V  V /  | |__| | | | (_| |  __/ |  \\__ \\
                                         \\/   |_|\\___| \\_/\\_/    \\____/|_|  \\__,_|\\___|_|  |___/
                                                                                               \s
                                                                                               \s
                                                                        
                                    """);
                            System.out.println();

                        }




                    }


                }
            }
        }
    }
}




