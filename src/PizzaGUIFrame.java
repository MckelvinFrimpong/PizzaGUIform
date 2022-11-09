import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class PizzaGUIFrame extends JFrame {
    JFrame frame = new JFrame();
    JPanel mainPnl;
    JPanel topPnl;
    JPanel midPnl;
    JPanel botPnl;
    JPanel crustPnl;
    JPanel sizePnl;
    JPanel toppingsPnl;

    JPanel formPnl;
    JPanel receiptPnl;

    JLabel titleLbl;
    JLabel toppingsLbl;

    JButton quitButton;
    JButton clearButton;
    JButton orderButton;

    JLabel crustLabel;
    JRadioButton thinCrustButton;
    JRadioButton regularCrustButton;
    JRadioButton deepDishButton;

    JComboBox<String> sizeBox = new JComboBox<>();

    JTextArea receiptText;

    ButtonGroup crustGroup;

    JCheckBox pepperoniCB;
    JCheckBox cheeseCB;
    JCheckBox sausageCB;
    JCheckBox avocadoCB;
    JCheckBox mushroomCB;
    JCheckBox jalapenosCB;
    JCheckBox parmesanCB;
    JCheckBox baconCB;

    public PizzaGUIFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createTopPanel();
        mainPnl.add(topPnl, BorderLayout.NORTH);
        createMiddlePanel();
        mainPnl.add(midPnl, BorderLayout.CENTER);
        createBottomPanel();
        mainPnl.add(botPnl, BorderLayout.SOUTH);

        add(mainPnl);

        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTopPanel() {
        topPnl = new JPanel();
        titleLbl = new JLabel("Pizza Order Form", JLabel.CENTER);
        titleLbl.setFont(new Font("Oswald", Font.BOLD, 28));

        topPnl.add(titleLbl);
    }

    private void createMiddlePanel() {
        midPnl = new JPanel();
        midPnl.setLayout(new BorderLayout());

        formPnl = new JPanel();
        formPnl.setLayout(new GridLayout(3, 1));

        receiptPnl = new JPanel();

        crustPnl = new JPanel();
        sizePnl = new JPanel();
        sizePnl.setLayout(new BorderLayout());
        toppingsPnl = new JPanel();
        toppingsPnl.setLayout(new GridLayout(2, 3));

        crustLabel = new JLabel("Crust:");
        crustLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        thinCrustButton = new JRadioButton("thin");
        regularCrustButton = new JRadioButton("regular");
        deepDishButton = new JRadioButton("deep dish");
        crustGroup = new ButtonGroup();
        crustGroup.add(thinCrustButton);
        crustGroup.add(regularCrustButton);
        crustGroup.add(deepDishButton);

        String[] sizes = {"small", "medium", "large", "super"};
        sizeBox = new JComboBox<String>(sizes);
        sizeBox.setSelectedIndex(0);

        toppingsLbl = new JLabel("Toppings:");
        toppingsLbl.setFont(new Font("Oswald", Font.BOLD, 18));
        pepperoniCB = new JCheckBox("Pepperoni");
        cheeseCB = new JCheckBox("Cheese");
        avocadoCB = new JCheckBox("Avocado");
        mushroomCB = new JCheckBox("Mushroom");
        sausageCB = new JCheckBox("Sausage");
        jalapenosCB = new JCheckBox("Jalapenos");
        parmesanCB = new JCheckBox("Parmesan");
        baconCB = new JCheckBox("Bacon");

        receiptText = new JTextArea(20, 60);

        crustPnl.add(crustLabel);
        crustPnl.add(thinCrustButton);
        crustPnl.add(regularCrustButton);
        crustPnl.add(deepDishButton);

        sizePnl.add(sizeBox);

        toppingsPnl.add(toppingsLbl);
        toppingsPnl.add(pepperoniCB);
        toppingsPnl.add(cheeseCB);
        toppingsPnl.add(avocadoCB);
        toppingsPnl.add(mushroomCB);
        toppingsPnl.add(sausageCB);
        toppingsPnl.add(jalapenosCB);
        toppingsPnl.add(parmesanCB);
        toppingsPnl.add(baconCB);

        formPnl.add(crustPnl);
        formPnl.add(sizePnl);
        formPnl.add(toppingsPnl);


        receiptPnl.add(receiptText);

        crustPnl.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Crust"));
        receiptPnl.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Receipt"));
        toppingsPnl.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Toppings"));
        sizePnl.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Size"));


        midPnl.add(formPnl, BorderLayout.CENTER);
        midPnl.add(receiptPnl, BorderLayout.SOUTH);

    }

    private void createBottomPanel() {
        botPnl = new JPanel();
        botPnl.setLayout(new GridLayout(1, 3));
        quitButton = new JButton("Quit");
        clearButton = new JButton("Clear");
        orderButton = new JButton("Order");

        orderButton.addActionListener(
                (ActionEvent ae) -> {
                    double total = 0;
                    receiptText.append("\n" + "=========================================");
                    //post crust part of receipt
                    if (thinCrustButton.isSelected()) {
                        receiptText.append("\n" + "Thin Crust         $1.00");
                        total += 1;
                    } else if (regularCrustButton.isSelected()) {
                        receiptText.append("\n" + "Regular Crust      $2.00");
                        total += 2;
                    } else if (deepDishButton.isSelected()) {
                        receiptText.append("\n" + "Deep Dish          $4.00");
                        total += 4;
                    }

                    System.out.println(crustGroup.getSelection());



                    switch (sizeBox.getSelectedIndex()) {
                        case 0:
                            receiptText.append("\n" + "Small              $8.00");
                            total += 8;
                            break;
                        case 1:
                            receiptText.append("\n" + "Regular           $12.00");
                            total += 12;
                            break;
                        case 2:
                            receiptText.append("\n" + "Large              $16.00");
                            total += 16;
                            break;
                        case 3:
                            receiptText.append("\n" + "Super            $20.00");
                            total += 20;
                            break;
                    }

                    //post all toppings to receipt
                    if (pepperoniCB.isSelected()) {
                        receiptText.append("\n" + "Pepperoni         $1.00");
                        total += 1;
                    }
                    if (cheeseCB.isSelected()) {
                        receiptText.append("\n" + "Cheese         $1.00");
                        total += 1;
                    }
                    if (avocadoCB.isSelected()) {
                        receiptText.append("\n" + "Avocado         $1.00");
                        total += 1;
                    }
                    if (mushroomCB.isSelected()) {
                        receiptText.append("\n" + "Mushroom        $1.00");
                        total += 1;
                    }
                    if (sausageCB.isSelected()) {
                        receiptText.append("\n" + "Sausage         $1.00");
                        total += 1;
                    }
                    if (jalapenosCB.isSelected()) {
                        receiptText.append("\n" + "Jalapenos         $1.00");
                        total += 1;
                    }
                    if (parmesanCB.isSelected()) {
                        receiptText.append("\n" + "Parmesan        $1.00");
                        total += 1;
                    }
                    if (baconCB.isSelected()) {
                        receiptText.append("\n" + "Bacon        $1.00");
                        total += 1;
                    }



                    //display subtotal, tax and total
                    String subTotal = new String("");
                    receiptText.append("\n" + "\n" + "Subtotal: $" + total);
                    double tax = total * .07;
                    String taxRound = String.format("%.2f", tax);
                    receiptText.append("\n" + "Tax:    $" + taxRound);
                    total += tax;
                    receiptText.append("\n" + "----------------------------------");
                    receiptText.append("\n" + "Total:    $" + total);
                    receiptText.append("\n" + "=========================================");
                }

        );
        quitButton.addActionListener(
                (ActionEvent ae) -> {
                    int a = JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?");

                    if (a == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }

        );

        clearButton.addActionListener(
                (ActionEvent ae) -> {
                    crustGroup.clearSelection();
                    sizeBox.setSelectedIndex(0);
                    pepperoniCB.setSelected(false);
                    cheeseCB.setSelected(false);
                    mushroomCB.setSelected(false);
                    avocadoCB.setSelected(false);
                    parmesanCB.setSelected(false);
                    sausageCB.setSelected(false);
                   jalapenosCB.setSelected(false);
                   baconCB.setSelected(false);
                }

        );
        botPnl.add(orderButton);
        botPnl.add(clearButton);
        botPnl.add(quitButton);
    }
}