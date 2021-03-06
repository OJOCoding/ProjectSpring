//Importing all libraries needed such as java swing, awt etc.
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder; ////cal


public class Gui extends JFrame {

    //Declaring labels and buttons
    final JLabel project_title;
    final JLabel game_name;
    private final JLabel current_dice1;
    private final JLabel current_dice2;
    private final JLabel previous_dice1;
    private final JLabel previous_dice2;
    private final JLabel message;
    private final JLabel user_score;
    private final JLabel computer_score;
    private final JLabel user1_score;
    private final JLabel user2_score;
    private final JLabel user3_score;

    private final JButton about_section;
    private final JButton start;
    private final JButton roll_again;
    private final JButton restart;
    private final JButton starting_button;
    private final JButton computer_mode;
    private final JButton multiplayer_mode;

    //Initializing variables needed throughout the program
    int dice1, dice2;
    int sum = 0;
    int result = 0;
    int roll_number_count = 1;
    int point_won = 0;
    int computer_points = 0;
    boolean multiplayer_check;
    boolean computer_player_check;
    int multi_user_point = 0;
    int multiplayer_count = 3;
    int user1_points = 0;
    int user2_points = 0;
    int user3_points = 0;

    //Creating a CardLayout
    CardLayout card;
    private final JPanel cardPane;

    public Gui() {

        super("Snake Eyes Game || Spring Project");//Set window title

        getContentPane().setBackground(new Color(255, 255, 255));//Set background color

        //Panels
        JPanel starting_panel = new JPanel();
        JPanel program_panel = new JPanel();
        JPanel starting_header = new JPanel();
        JPanel program_header = new JPanel();
        JPanel buttons = new JPanel();
        JPanel current_dices = new JPanel();
        JPanel previous_dices = new JPanel();
        JPanel messages = new JPanel();
        JPanel scoreboard = new JPanel();
        JPanel multiplayer_scoreboard = new JPanel();
        JPanel scoreboards_holder = new JPanel();
        JPanel dice_holder = new JPanel();
        JPanel computer_multiplayer_buttons = new JPanel();

        //Create card panes
        cardPane = new JPanel();
        card = new CardLayout();
        cardPane.setLayout(card);
        cardPane.add(starting_panel, "C1");
        cardPane.add(program_panel, "C2");
        add(cardPane);

        //Set preferences for both card panes
        starting_panel.setSize(375, 350);
        starting_panel.setBackground(Color.white);
        program_panel.setPreferredSize(new Dimension(375, 350));

        //ImageIcons
        Icon starting_background = new ImageIcon("out/SnakeEye.jpg");
        Icon roll_again_image = new ImageIcon("out/D.png");
        Icon dice_image1 = new ImageIcon("out/1.png");
        Icon dice_image2 = new ImageIcon("out/1.png");
        Icon empty_dice_image = new ImageIcon("out/null.png");

        //Labels
        game_name = new JLabel("WELCOME TO SNAKE EYES GAME!!!");
        game_name.setToolTipText("Oni Luca - Spring Project");
        var starting_image = new JLabel(starting_background);

        project_title = new JLabel("WELCOME TO SNAKE EYES GAME!!!");
        project_title.setToolTipText("Hello there! This is my submission for Spring CS Project!");
        message = new JLabel("START");

        user_score = new JLabel("User Points are : ");
        computer_score = new JLabel("Computer Points are : ");
        user1_score = new JLabel("Player 1 Points are :");
        user2_score = new JLabel("Player 2 Points are :");
        user3_score = new JLabel("Player 3 Points are :");

        current_dice1 = new JLabel(empty_dice_image);
        current_dice2 = new JLabel(dice_image2);
        previous_dice1 = new JLabel(dice_image1);
        previous_dice2 = new JLabel(empty_dice_image);

        //Buttons
        starting_button = new JButton("Start Game!");
        about_section = new JButton("About Section");
        start = new JButton("START");

        roll_again = new JButton(roll_again_image);
        roll_again.setToolTipText("Roll again!");
        roll_again.setEnabled(false);

        restart = new JButton("Restart");
        restart.setToolTipText("After you win or lose, please press the button to restart the game and register your points!");
        restart.setEnabled(false);

        computer_mode = new JButton("Computer Mode");
        multiplayer_mode = new JButton("Multiplayer Mode");

        //Adding components to panels
        starting_header.add(game_name);
        program_header.add(project_title);

        buttons.add(about_section);
        buttons.add(start);
        buttons.add(roll_again);
        buttons.add(restart);

        current_dices.add(current_dice1);
        current_dices.add(current_dice2);
        current_dices.setBorder(BorderFactory.createTitledBorder("Current Dices"));

        previous_dices.add(previous_dice1);
        previous_dices.add(previous_dice2);
        previous_dices.setBorder(BorderFactory.createTitledBorder("Previous Dices"));

        dice_holder.add(current_dices);
        dice_holder.add(previous_dices);
        dice_holder.setLayout(new BoxLayout(dice_holder, BoxLayout.X_AXIS));
        dice_holder.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        messages.add(message);
        messages.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        scoreboard.add(user_score);
        scoreboard.add(computer_score);
        scoreboard.setLayout(new BoxLayout(scoreboard, BoxLayout.Y_AXIS));
        scoreboard.setBorder(BorderFactory.createTitledBorder("ScoreBoard"));

        multiplayer_scoreboard.add(user1_score);
        multiplayer_scoreboard.add(user2_score);
        multiplayer_scoreboard.add(user3_score);
        multiplayer_scoreboard.setLayout(new BoxLayout(multiplayer_scoreboard, BoxLayout.Y_AXIS));
        multiplayer_scoreboard.setBorder(BorderFactory.createTitledBorder("Multiplayer Score"));

        scoreboards_holder.add(scoreboard);
        scoreboards_holder.add(multiplayer_scoreboard);
        scoreboards_holder.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        scoreboards_holder.setLayout(new BoxLayout(scoreboards_holder, BoxLayout.X_AXIS));

        computer_multiplayer_buttons.add(computer_mode);
        computer_multiplayer_buttons.add(multiplayer_mode);

        //Adding panels to first card pane
        starting_panel.setLayout(new BorderLayout());
        starting_panel.add(starting_header, BorderLayout.CENTER);
        starting_panel.add(starting_image, BorderLayout.NORTH);
        starting_panel.add(starting_button, BorderLayout.SOUTH);

        //Adding panels to second card pane
        program_panel.add(program_header);
        program_panel.add(buttons);
        program_panel.add(dice_holder);
        program_panel.add(messages);
        program_panel.add(scoreboards_holder);
        program_panel.add(computer_multiplayer_buttons);
        program_panel.setLayout(new FlowLayout());

        //Creating event handle and action listeners
        EventHandler handle = new EventHandler();
        starting_button.addActionListener(handle);
        about_section.addActionListener(handle);
        start.addActionListener(handle);
        roll_again.addActionListener(handle);
        restart.addActionListener(handle);
        computer_mode.addActionListener(handle);
        multiplayer_mode.addActionListener(handle);

    }

    private class EventHandler extends Component implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            if (event.getSource().equals(starting_button)) { //CardLayout Switch and starting button
                card.next(cardPane);
                pack(); // Fit size of JFrame
                revalidate(); // Mark JFrame as "dirty"
                repaint(); // Tell GUI manager to redraw
            }

            //Shows info on the creator of the program
            if (event.getSource().equals(about_section)) {
                JOptionPane.showMessageDialog(this, "Hello there! My name is Oni Luca and this is my Spring I Project submission called \"Snake Eyes\"",
                        "About Section",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            //Starting Button
            if (event.getSource().equals(start)) {

                Icon image, image2;

                //Creating two random dices
                dice1 = (int) (Math.random() * ((6 - 1) + 1) + 1);
                String dice_no1 = Integer.toString(dice1);
                dice_no1 = dice_no1.concat(".png");
                image = new ImageIcon("out/" + dice_no1);

                dice2 = (int) (Math.random() * ((6 - 1) + 1) + 1);
                String dice_no2 = Integer.toString(dice2);
                dice_no2 = dice_no2.concat(".png");
                image2 = new ImageIcon("out/" + dice_no2);

                current_dice1.setIcon(image);
                current_dice2.setIcon(image2);

                sum = dice1 + dice2;
                //Win condition
                if (sum == 7 || sum == 11) {
                    message.setText("You Win!");
                    roll_again.setEnabled(false);
                    if (multiplayer_check) {
                        multi_user_point = multi_user_point + 10;
                    } else if (computer_player_check) {
                        computer_points = computer_points + 10;
                    } else {
                        point_won = point_won + 10;
                    }
                    restart.setEnabled(true);
                } else if (sum == 2 || sum == 3 || sum == 12) { //Loss condition
                    message.setText("You Lose!");
                    roll_again.setEnabled(false);
                    if (multiplayer_check) {
                        multi_user_point = multi_user_point - 5;
                    } else if (computer_player_check) {
                        computer_points = computer_points - 5;
                    } else {
                        point_won = point_won - 5;
                    }
                    restart.setEnabled(true);
                } else {
                    message.setText("Roll Again!");
                    previous_dice1.setIcon(image);
                    previous_dice2.setIcon(image2);
                    roll_again.setEnabled(true);
                }

                result = sum;
                start.setEnabled(false);
            }
            //Roll again button
            if (event.getSource().equals(roll_again)) {

                Icon image, image2;
                //Creating two random dices
                dice1 = (int) (Math.random() * ((6 - 1) + 1) + 1);
                String dice_no1 = Integer.toString(dice1);
                dice_no1 = dice_no1.concat(".png");
                image = new ImageIcon("out/" + dice_no1);

                dice2 = (int) (Math.random() * ((6 - 1) + 1) + 1);
                String dice_no2 = Integer.toString(dice2);
                dice_no2 = dice_no2.concat(".png");
                image2 = new ImageIcon("out/" + dice_no2);

                current_dice1.setIcon(image);
                current_dice2.setIcon(image2);

                sum = dice1 + dice2;

                if (sum == 7) { //Loss condition
                    message.setText("You Lose!");
                    roll_again.setEnabled(false);
                    if (multiplayer_check) {
                        multi_user_point = multi_user_point - 3;
                    } else if (computer_player_check) {
                        computer_points = computer_points - 3;
                    } else {
                        point_won = point_won - 3;
                    }
                    restart.setEnabled(true);
                } else if (sum == result) { //Win Condition
                    message.setText("You win!");
                    if (multiplayer_check) {
                        multi_user_point = multi_user_point + (10 - roll_number_count);
                        roll_number_count = 0;
                    } else if (computer_player_check) {
                        computer_points = computer_points + (10 - roll_number_count);
                        roll_number_count = 0;
                    } else {
                        point_won = point_won + (10 - roll_number_count);
                        roll_number_count = 0;
                    }
                    roll_again.setEnabled(false);
                    restart.setEnabled(true);
                } else {
                    roll_number_count++;
                }
            }
            //Restart Button
            if (event.getSource().equals(restart)) {
                start.setEnabled(true);
                restart.setEnabled(false);
                //Sets Point based on playing mode
                if (multiplayer_check) {

                    if (multiplayer_count == 3) {
                        user1_points = user1_points + multi_user_point;
                        multi_user_point = 0;
                        user1_score.setText("Player 1 Points are :" + user1_points);
                        multiplayer_count--;
                    } else if (multiplayer_count == 2) {
                        user2_points = user2_points + multi_user_point;
                        multi_user_point = 0;
                        user2_score.setText("Player 2 Points are :" + user2_points);
                        multiplayer_count--;
                    } else {
                        user3_points = user3_points + multi_user_point;
                        multi_user_point = 0;
                        user3_score.setText("Player 3 Points are :" + user3_points);
                        multiplayer_count = multiplayer_count * 3;
                        multiplayer_check = false;
                        multiplayer_mode.setEnabled(true);
                    }

                } else if (computer_player_check) {
                    computer_score.setText("Computer Points are: " + computer_points);
                } else {
                    user_score.setText("User Points are: " + point_won);
                }
            }

            //Computer Mode
            if (event.getSource().equals(computer_mode)) {

                String round = JOptionPane.showInputDialog("\nEnter the number of rounds you want the computer to play!");

                int round_count = Integer.parseInt(round);

                computer_player_check = true;

                while (round_count != 0) {
                    start.doClick();
                    if (roll_again.isEnabled()) {
                        while (roll_again.isEnabled()) {
                            roll_again.doClick();
                        }
                    } else {
                        restart.doClick();
                    }

                    restart.doClick();
                    round_count--;

                }
                computer_player_check = false;
            }

            //Multiplayer Mode
            if (event.getSource().equals(multiplayer_mode)) {

                multiplayer_check = true;
                JOptionPane.showMessageDialog(this, "Multiplayer Mode ON",
                        "Multiplayer Mode",
                        JOptionPane.WARNING_MESSAGE);
                multiplayer_mode.setEnabled(false);

            }
        }
    }
}












