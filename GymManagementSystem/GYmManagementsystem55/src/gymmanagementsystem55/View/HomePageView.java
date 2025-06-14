package gymmanagementsystem55.View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.BasicStroke;
import javax.swing.SpinnerDateModel;

public class HomePageView extends JFrame {
    private JButton getStartedButton;
    private JButton signInButton;
    private JLabel pricingLabel, aboutLabel, homeLabel, signInLabel;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public HomePageView() {
        setTitle("TANUVEDA Gym Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Top Navigation
        JPanel navPanel = new JPanel(new BorderLayout());
        navPanel.setBackground(Color.WHITE);
        navPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        // Insert gym logo image instead of 'GYM' text
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        logoPanel.setBackground(Color.WHITE);
        try {
            BufferedImage navLogoImg = null;
            java.net.URL navLogoUrl = getClass().getResource("/Imagepicker/image.png");
            if (navLogoUrl != null) {
                navLogoImg = ImageIO.read(navLogoUrl);
            } else {
                java.io.InputStream is = getClass().getResourceAsStream("/Imagepicker/image.png");
                if (is != null) navLogoImg = ImageIO.read(is);
            }
            if (navLogoImg != null) {
                int imgW = 48, imgH = 48;
                Image scaled = navLogoImg.getScaledInstance(imgW, imgH, Image.SCALE_SMOOTH);
                JLabel imgLabel = new JLabel(new ImageIcon(scaled));
                logoPanel.add(imgLabel);
                logoPanel.add(Box.createHorizontalStrut(10));
            }
        } catch (IOException ex) {
            // fallback: do nothing
        }
        JLabel tanuvedaLabel = new JLabel("TANUVEDA");
        tanuvedaLabel.setFont(new Font("Montserrat", Font.BOLD, 22));
        tanuvedaLabel.setForeground(Color.BLACK);
        logoPanel.add(tanuvedaLabel);
        navPanel.add(logoPanel, BorderLayout.WEST);
        JPanel navLinks = new JPanel();
        navLinks.setBackground(Color.WHITE);
        navLinks.setLayout(new BoxLayout(navLinks, BoxLayout.X_AXIS));
        homeLabel = new JLabel("HOME");
        homeLabel.setFont(new Font("Montserrat", Font.BOLD, 16));
        homeLabel.setForeground(new Color(230, 57, 89));
        homeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        navLinks.add(homeLabel);
        navLinks.add(Box.createHorizontalStrut(30));
        pricingLabel = new JLabel("PRICING");
        pricingLabel.setFont(new Font("Montserrat", Font.PLAIN, 16));
        pricingLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        navLinks.add(pricingLabel);
        navLinks.add(Box.createHorizontalStrut(30));
        aboutLabel = new JLabel("ABOUT");
        aboutLabel.setFont(new Font("Montserrat", Font.PLAIN, 16));
        aboutLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        navLinks.add(aboutLabel);
        navLinks.add(Box.createHorizontalStrut(30));
        signInLabel = new JLabel("Sign In");
        signInLabel.setFont(new Font("Montserrat", Font.BOLD, 16));
        signInLabel.setForeground(new Color(230, 57, 89));
        signInLabel.setBorder(BorderFactory.createLineBorder(new Color(230, 57, 89), 2));
        signInLabel.setOpaque(true);
        signInLabel.setBackground(Color.WHITE);
        signInLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signInLabel.setHorizontalAlignment(SwingConstants.CENTER);
        signInLabel.setPreferredSize(new Dimension(90, 36));
        navLinks.add(signInLabel);
        navPanel.add(navLinks, BorderLayout.EAST);
        add(navPanel, BorderLayout.NORTH);

        // Card Layout for main content
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBackground(new Color(62, 74, 99));

        // HERO PANEL (scaled down and with real image)
        JPanel heroSection = new JPanel(new GridBagLayout());
        heroSection.setBackground(new Color(62, 74, 99));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(62, 74, 99));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(new EmptyBorder(30, 60, 30, 15));
        leftPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        JLabel heroTitle = new JLabel("<html><div style='text-align:left;'><span style='font-size:38px;font-weight:bold;'>Train Insane<br>or Remain the Same</span></div></html>");
        heroTitle.setForeground(Color.WHITE);
        heroTitle.setFont(new Font("Montserrat", Font.BOLD, 38));
        heroTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(heroTitle);
        leftPanel.add(Box.createVerticalStrut(12));

        JLabel heroSubtitle = new JLabel("Master Your Body, Elevate Your Life");
        heroSubtitle.setForeground(new Color(160, 170, 190));
        heroSubtitle.setFont(new Font("Montserrat", Font.PLAIN, 17));
        heroSubtitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(heroSubtitle);
        leftPanel.add(Box.createVerticalStrut(12));

        JLabel heroDesc = new JLabel("<html><div style='text-align:left;width:280px;'>Success in the gym isn't given—it's earned through sweat, discipline, and the relentless pursuit of becoming your strongest self</div></html>");
        heroDesc.setForeground(Color.WHITE);
        heroDesc.setFont(new Font("Montserrat", Font.PLAIN, 14));
        heroDesc.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(heroDesc);
        leftPanel.add(Box.createVerticalStrut(20));

        // Insert gym logo image below hero text and above Get Started button
        try {
            BufferedImage heroLogoImg = null;
            java.net.URL heroLogoUrl = getClass().getResource("/gymmanagementsystem55/View/gym_logo_small.png");
            if (heroLogoUrl != null) {
                heroLogoImg = ImageIO.read(heroLogoUrl);
            } else {
                java.io.InputStream is = getClass().getResourceAsStream("/gymmanagementsystem55/View/gym_logo_small.png");
                if (is != null) heroLogoImg = ImageIO.read(is);
            }
            if (heroLogoImg != null) {
                int imgW = 80, imgH = 80;
                Image scaled = heroLogoImg.getScaledInstance(imgW, imgH, Image.SCALE_SMOOTH);
                JLabel imgLabel = new JLabel(new ImageIcon(scaled));
                imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                leftPanel.add(Box.createVerticalStrut(18));
                leftPanel.add(imgLabel);
                leftPanel.add(Box.createVerticalStrut(18));
            }
        } catch (IOException ex) {
            // fallback: do nothing
        }

        getStartedButton = new JButton("Get Started  →");
        getStartedButton.setBackground(new Color(230, 57, 89));
        getStartedButton.setForeground(Color.WHITE);
        getStartedButton.setFont(new Font("Montserrat", Font.BOLD, 20));
        getStartedButton.setFocusPainted(false);
        getStartedButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        getStartedButton.setBorder(BorderFactory.createEmptyBorder(10, 28, 10, 28));
        leftPanel.add(getStartedButton);

        // Right Panel: Real image with abstract background
        JPanel rightPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(230, 140, 120));
                g2.fillRoundRect(80, 40, 140, 70, 50, 50);
                g2.setColor(new Color(120, 170, 220));
                g2.fillRoundRect(120, 80, 200, 50, 30, 30);
                g2.setColor(new Color(255, 215, 0));
                g2.fillRoundRect(240, 170, 30, 10, 10, 10);
                g2.fillRoundRect(220, 200, 20, 8, 8, 8);
            }
        };
        rightPanel.setOpaque(false);
        rightPanel.setLayout(null);
        rightPanel.setPreferredSize(new Dimension(600, 420));

        // Load and scale the home image
        try {
            BufferedImage homeImg = null;
            java.net.URL homeImgUrl = getClass().getResource("/Imagepicker/homeimg.png");
            if (homeImgUrl != null) {
                homeImg = ImageIO.read(homeImgUrl);
            } else {
                java.io.InputStream is = getClass().getResourceAsStream("/Imagepicker/homeimg.png");
                if (is != null) homeImg = ImageIO.read(is);
            }
            if (homeImg != null) {
                int imgW = (int)(350 * 1.55), imgH = (int)(270 * 1.55);
                int shiftX = (int)(-0.10 * imgW);
                Image scaled = homeImg.getScaledInstance(imgW, imgH, Image.SCALE_SMOOTH);
                JLabel imgLabel = new JLabel(new ImageIcon(scaled));
                imgLabel.setBounds(shiftX, 0, imgW, imgH);
                rightPanel.add(imgLabel);
            }
        } catch (IOException ex) {
            JLabel imgLabel = new JLabel("[Image not found]");
            imgLabel.setForeground(Color.WHITE);
            imgLabel.setBounds(30, 40, 350, 270);
            rightPanel.add(imgLabel);
        }

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.6;
        heroSection.add(leftPanel, gbc);
        gbc.gridx = 1;
        gbc.weightx = 0.4;
        heroSection.add(rightPanel, gbc);

        // PRICING CARD
        JPanel pricingCard = new JPanel();
        pricingCard.setBackground(new Color(245, 247, 251));
        pricingCard.setLayout(new BoxLayout(pricingCard, BoxLayout.Y_AXIS));

        JLabel pricingHeader = new JLabel("SIMPLE, TRANSPARENT PRICING");
        pricingHeader.setFont(new Font("Montserrat", Font.BOLD, 36));
        pricingHeader.setForeground(new Color(40, 50, 70));
        pricingHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        pricingCard.add(Box.createVerticalStrut(20));
        pricingCard.add(pricingHeader);

        JLabel pricingSub = new JLabel("<html><div style='text-align:center;'>Choose a plan that fits your GYM needs<br>all plan include core features with no hidden fees</div></html>");
        pricingSub.setFont(new Font("Montserrat", Font.PLAIN, 20));
        pricingSub.setForeground(new Color(160, 170, 190));
        pricingSub.setAlignmentX(Component.CENTER_ALIGNMENT);
        pricingSub.setHorizontalAlignment(SwingConstants.CENTER);
        pricingCard.add(Box.createVerticalStrut(10));
        pricingCard.add(pricingSub);
        pricingCard.add(Box.createVerticalStrut(30));

        JPanel plansPanel = new JPanel();
        plansPanel.setBackground(new Color(245, 247, 251));
        plansPanel.setLayout(new BoxLayout(plansPanel, BoxLayout.X_AXIS));
        plansPanel.setBorder(new EmptyBorder(20, 40, 40, 40));
        plansPanel.add(Box.createHorizontalGlue());

        Dimension cardSize = new Dimension(320, 480);
        Dimension buttonSize = new Dimension(180, 44);

        // Helper for feature list
        java.util.function.Function<String[], JPanel> featureList = features -> {
            JPanel list = new JPanel();
            list.setBackground(null);
            list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
            list.setAlignmentX(Component.CENTER_ALIGNMENT);
            for (String f : features) {
                JLabel l = new JLabel("• " + f);
                l.setFont(new Font("Montserrat", Font.PLAIN, 15));
                l.setAlignmentX(Component.CENTER_ALIGNMENT);
                l.setHorizontalAlignment(SwingConstants.CENTER);
                l.setBorder(new EmptyBorder(0, 0, 0, 0));
                list.add(l);
            }
            return list;
        };

        // BASIC PLAN
        JPanel basicPanel = new JPanel();
        basicPanel.setBackground(new Color(252, 254, 255));
        basicPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createDashedBorder(new Color(120, 140, 170), 2, 6),
            new EmptyBorder(24, 24, 24, 24)));
        basicPanel.setLayout(new BoxLayout(basicPanel, BoxLayout.Y_AXIS));
        basicPanel.setPreferredSize(cardSize);
        basicPanel.setMaximumSize(cardSize);
        basicPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        basicPanel.add(Box.createVerticalStrut(8));
        JLabel basicTitle = new JLabel("BASIC");
        basicTitle.setFont(new Font("Montserrat", Font.BOLD, 28));
        basicTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        basicPanel.add(basicTitle);
        basicPanel.add(Box.createVerticalStrut(8));
        JLabel basicDesc = new JLabel("Perfect for newcomers and beginners!!");
        basicDesc.setFont(new Font("Montserrat", Font.PLAIN, 15));
        basicDesc.setAlignmentX(Component.CENTER_ALIGNMENT);
        basicPanel.add(basicDesc);
        basicPanel.add(Box.createVerticalStrut(18));
        JLabel basicPrice = new JLabel("NPR 3500");
        basicPrice.setFont(new Font("Montserrat", Font.BOLD, 32));
        basicPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        basicPanel.add(basicPrice);
        JLabel basicPer = new JLabel("/PER MONTH");
        basicPer.setFont(new Font("Montserrat", Font.PLAIN, 14));
        basicPer.setAlignmentX(Component.CENTER_ALIGNMENT);
        basicPanel.add(basicPer);
        basicPanel.add(Box.createVerticalStrut(18));
        basicPanel.add(featureList.apply(new String[]{
            "Full GYM access",
            "Free induction session",
            "Locker facility"
        }));
        basicPanel.add(Box.createVerticalGlue());
        JButton basicBtn = new JButton("Get Started");
        basicBtn.setBackground(new Color(30, 38, 54));
        basicBtn.setForeground(Color.WHITE);
        basicBtn.setFont(new Font("Montserrat", Font.BOLD, 18));
        basicBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        basicBtn.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        basicBtn.setMaximumSize(buttonSize);
        basicBtn.setPreferredSize(buttonSize);
        basicBtn.addActionListener(e -> showEsewaPopup());
        basicPanel.add(Box.createVerticalStrut(18));
        basicPanel.add(basicBtn);

        // STANDARD PLAN
        JPanel standardPanel = new JPanel();
        standardPanel.setBackground(new Color(255, 245, 247));
        standardPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createDashedBorder(new Color(230, 57, 89), 2, 6),
            new EmptyBorder(24, 24, 24, 24)));
        standardPanel.setLayout(new BoxLayout(standardPanel, BoxLayout.Y_AXIS));
        standardPanel.setPreferredSize(cardSize);
        standardPanel.setMaximumSize(cardSize);
        standardPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        standardPanel.add(Box.createVerticalStrut(8));
        JPanel mostPopular = new JPanel();
        mostPopular.setBackground(new Color(230, 57, 89));
        JLabel mostPopularLabel = new JLabel("Most Popular");
        mostPopularLabel.setFont(new Font("Montserrat", Font.BOLD, 15));
        mostPopularLabel.setForeground(Color.WHITE);
        mostPopular.add(mostPopularLabel);
        mostPopular.setAlignmentX(Component.CENTER_ALIGNMENT);
        mostPopular.setMaximumSize(new Dimension(140, 28));
        standardPanel.add(mostPopular);
        standardPanel.add(Box.createVerticalStrut(8));
        JLabel standardTitle = new JLabel("STANDARD");
        standardTitle.setFont(new Font("Montserrat", Font.BOLD, 28));
        standardTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        standardPanel.add(standardTitle);
        standardPanel.add(Box.createVerticalStrut(8));
        JLabel standardDesc = new JLabel("Ideal for regular fitness enthusiasts");
        standardDesc.setFont(new Font("Montserrat", Font.PLAIN, 15));
        standardDesc.setAlignmentX(Component.CENTER_ALIGNMENT);
        standardPanel.add(standardDesc);
        standardPanel.add(Box.createVerticalStrut(18));
        JLabel standardPrice = new JLabel("NPR 5000");
        standardPrice.setFont(new Font("Montserrat", Font.BOLD, 32));
        standardPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        standardPanel.add(standardPrice);
        JLabel standardPer = new JLabel("/PER MONTH");
        standardPer.setFont(new Font("Montserrat", Font.PLAIN, 14));
        standardPer.setAlignmentX(Component.CENTER_ALIGNMENT);
        standardPanel.add(standardPer);
        standardPanel.add(Box.createVerticalStrut(18));
        standardPanel.add(featureList.apply(new String[]{
            "Everything in BASIC",
            "2 Group Classes / week",
            "Diet Consultation"
        }));
        standardPanel.add(Box.createVerticalGlue());
        JButton standardBtn = new JButton("Get Started");
        standardBtn.setBackground(new Color(230, 57, 89));
        standardBtn.setForeground(Color.WHITE);
        standardBtn.setFont(new Font("Montserrat", Font.BOLD, 18));
        standardBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        standardBtn.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        standardBtn.setMaximumSize(buttonSize);
        standardBtn.setPreferredSize(buttonSize);
        standardBtn.addActionListener(e -> showEsewaPopup());
        standardPanel.add(Box.createVerticalStrut(18));
        standardPanel.add(standardBtn);

        // PREMIUM PLAN
        JPanel premiumPanel = new JPanel();
        premiumPanel.setBackground(new Color(252, 254, 255));
        premiumPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createDashedBorder(new Color(120, 140, 170), 2, 6),
            new EmptyBorder(24, 24, 24, 24)));
        premiumPanel.setLayout(new BoxLayout(premiumPanel, BoxLayout.Y_AXIS));
        premiumPanel.setPreferredSize(cardSize);
        premiumPanel.setMaximumSize(cardSize);
        premiumPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        premiumPanel.add(Box.createVerticalStrut(8));
        JLabel premiumTitle = new JLabel("PREMIUM");
        premiumTitle.setFont(new Font("Montserrat", Font.BOLD, 28));
        premiumTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        premiumPanel.add(premiumTitle);
        premiumPanel.add(Box.createVerticalStrut(8));
        JLabel premiumDesc = new JLabel("Ideal for regular fitness enthusiasts");
        premiumDesc.setFont(new Font("Montserrat", Font.PLAIN, 15));
        premiumDesc.setAlignmentX(Component.CENTER_ALIGNMENT);
        premiumPanel.add(premiumDesc);
        premiumPanel.add(Box.createVerticalStrut(18));
        JLabel premiumPrice = new JLabel("NPR 7000");
        premiumPrice.setFont(new Font("Montserrat", Font.BOLD, 32));
        premiumPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        premiumPanel.add(premiumPrice);
        JLabel premiumPer = new JLabel("/PER MONTH");
        premiumPer.setFont(new Font("Montserrat", Font.PLAIN, 14));
        premiumPer.setAlignmentX(Component.CENTER_ALIGNMENT);
        premiumPanel.add(premiumPer);
        premiumPanel.add(Box.createVerticalStrut(18));
        premiumPanel.add(featureList.apply(new String[]{
            "Everything in STANDARD",
            "Unlimited Classes",
            "Personal Trainer/Sauna"
        }));
        premiumPanel.add(Box.createVerticalGlue());
        JButton premiumBtn = new JButton("Get Started");
        premiumBtn.setBackground(new Color(30, 38, 54));
        premiumBtn.setForeground(Color.WHITE);
        premiumBtn.setFont(new Font("Montserrat", Font.BOLD, 18));
        premiumBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        premiumBtn.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        premiumBtn.setMaximumSize(buttonSize);
        premiumBtn.setPreferredSize(buttonSize);
        premiumBtn.addActionListener(e -> showEsewaPopup());
        premiumPanel.add(Box.createVerticalStrut(18));
        premiumPanel.add(premiumBtn);

        plansPanel.add(basicPanel);
        plansPanel.add(Box.createHorizontalStrut(30));
        plansPanel.add(standardPanel);
        plansPanel.add(Box.createHorizontalStrut(30));
        plansPanel.add(premiumPanel);
        plansPanel.add(Box.createHorizontalGlue());
        pricingCard.add(plansPanel);

        // ABOUT CARD
        JPanel aboutCard = new JPanel();
        aboutCard.setBackground(new Color(245, 247, 251));
        aboutCard.setLayout(new BoxLayout(aboutCard, BoxLayout.Y_AXIS));

        JLabel aboutHeader = new JLabel("About Tanuveda");
        aboutHeader.setFont(new Font("Montserrat", Font.BOLD, 36));
        aboutHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        aboutCard.add(Box.createVerticalStrut(20));
        aboutCard.add(aboutHeader);

        JLabel aboutSub = new JLabel("Master Your Body, Elevate Your Life");
        aboutSub.setFont(new Font("Montserrat", Font.PLAIN, 24));
        aboutSub.setForeground(new Color(90, 110, 140));
        aboutSub.setAlignmentX(Component.CENTER_ALIGNMENT);
        aboutCard.add(Box.createVerticalStrut(10));
        aboutCard.add(aboutSub);
        aboutCard.add(Box.createVerticalStrut(30));

        JPanel aboutMainPanel = new JPanel(new java.awt.GridBagLayout());
        aboutMainPanel.setBackground(Color.WHITE);
        aboutMainPanel.setBorder(new EmptyBorder(40, 100, 40, 60));
        java.awt.GridBagConstraints gbcAbout = new java.awt.GridBagConstraints();
        gbcAbout.insets = new Insets(0, 0, 0, 0);
        gbcAbout.fill = java.awt.GridBagConstraints.BOTH;
        gbcAbout.weighty = 1;

        // Left: Story
        JPanel storyPanel = new JPanel();
        storyPanel.setBackground(Color.WHITE);
        storyPanel.setLayout(new BoxLayout(storyPanel, BoxLayout.Y_AXIS));
        JLabel storyTitle = new JLabel("Our Story");
        storyTitle.setFont(new Font("Montserrat", Font.BOLD, 32));
        storyTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        storyPanel.add(Box.createVerticalStrut(30));
        storyPanel.add(storyTitle);
        storyPanel.add(Box.createVerticalStrut(20));
        JLabel storyText = new JLabel("<html><div style='width:420px;font-size:20px;text-align:left;'>I started this gym to give others what fitness gave me—a second chance to grow, focus, and level up in life. This isn't just a gym; it's a place to push limits and find your strength.<br><br>— Khatiwada and team, Founder</div></html>");
        storyText.setFont(new Font("Montserrat", Font.PLAIN, 20));
        storyText.setAlignmentX(Component.LEFT_ALIGNMENT);
        storyPanel.add(storyText);

        // Right: Illustration on abstract shape (centered and improved proportions)
        JPanel aboutLogoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Abstract shape
                g2.setColor(new Color(196, 128, 110));
                g2.fillRoundRect(0, 0, 340, 340, 140, 140);
                // Man in suit (centered)
                int cx = 170, cy = 170;
                // Head
                g2.setColor(new Color(220, 190, 160));
                g2.fillOval(cx-38, cy-90, 76, 76);
                // Body (suit)
                g2.setColor(new Color(40, 40, 60));
                int[] xBody = {cx-50, cx, cx+50};
                int[] yBody = {cy-10, cy+90, cy-10};
                g2.fillPolygon(xBody, yBody, 3);
                // Shirt
                g2.setColor(new Color(240, 240, 245));
                int[] xShirt = {cx-16, cx, cx+16};
                int[] yShirt = {cy+20, cy+80, cy+20};
                g2.fillPolygon(xShirt, yShirt, 3);
                // Tie
                g2.setColor(new Color(230, 57, 89));
                int[] xTie = {cx-3, cx, cx+3};
                int[] yTie = {cy+30, cy+75, cy+30};
                g2.fillPolygon(xTie, yTie, 3);
                // Arms (suit sleeves)
                g2.setStroke(new BasicStroke(14f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2.setColor(new Color(40, 40, 60));
                g2.drawLine(cx-50, cy+10, cx-110, cy+60);
                g2.drawLine(cx+50, cy+10, cx+110, cy+60);
                // Hands
                g2.setStroke(new BasicStroke(16f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2.setColor(new Color(220, 190, 160));
                g2.drawLine(cx-110, cy+60, cx-110, cy+60);
                g2.drawLine(cx+110, cy+60, cx+110, cy+60);
                // Simple face (eyes, mouth)
                g2.setColor(new Color(80, 60, 40));
                g2.fillOval(cx-16, cy-68, 8, 8);
                g2.fillOval(cx+8, cy-68, 8, 8);
                g2.setStroke(new BasicStroke(2.5f));
                g2.drawArc(cx-8, cy-52, 16, 8, 190, 160);
            }
        };
        aboutLogoPanel.setOpaque(false);
        aboutLogoPanel.setLayout(null);
        aboutLogoPanel.setPreferredSize(new Dimension(340, 340));

        gbcAbout.gridx = 0;
        gbcAbout.gridy = 0;
        gbcAbout.weightx = 0.6;
        gbcAbout.anchor = java.awt.GridBagConstraints.NORTHWEST;
        aboutMainPanel.add(storyPanel, gbcAbout);
        gbcAbout.gridx = 1;
        gbcAbout.weightx = 0.4;
        gbcAbout.anchor = java.awt.GridBagConstraints.CENTER;
        aboutMainPanel.add(aboutLogoPanel, gbcAbout);
        aboutCard.add(aboutMainPanel);

        // SIGN IN CARD
        JPanel signInCard = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw background image (optional: replace with your own image path)
                try {
                    BufferedImage bgImg = null;
                    java.net.URL bgUrl = getClass().getResource("/Imagepicker/gym_bg.jpg");
                    if (bgUrl != null) {
                        bgImg = ImageIO.read(bgUrl);
                    } else {
                        java.io.InputStream is = getClass().getResourceAsStream("/Imagepicker/gym_bg.jpg");
                        if (is != null) bgImg = ImageIO.read(is);
                    }
                    if (bgImg != null) {
                        g.drawImage(bgImg, 0, 0, getWidth(), getHeight(), this);
                        // Draw semi-transparent overlay
                        Graphics2D g2 = (Graphics2D) g;
                        g2.setColor(new Color(255,255,255,180));
                        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
                    }
                } catch (Exception ex) {
                    // fallback: do nothing
                }
            }
        };
        signInCard.setOpaque(false);
        signInCard.setLayout(null);

        int cardW = 1200, cardH = 700;
        int boxW = 200, boxH = 200, boxGap = 80;
        int totalBoxW = boxW * 2 + boxGap;
        int centerX = (cardW - totalBoxW) / 2;
        int centerY = 220;

        JLabel chooseLabel = new JLabel("Choose your role: Admin or User.");
        chooseLabel.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 32));
        chooseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        chooseLabel.setForeground(Color.BLACK);
        chooseLabel.setBounds(0, 60, cardW, 50);
        signInCard.add(chooseLabel);

        // Admin Panel with hover effect
        final boolean[] adminHovered = {false};
        JPanel adminPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(adminHovered[0] ? new Color(220, 220, 220, 255) : new Color(240, 240, 240, 230));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 36, 36);
                if (adminHovered[0]) {
                    g2.setColor(new Color(180, 180, 180, 120));
                    g2.setStroke(new BasicStroke(4f));
                    g2.drawRoundRect(2, 2, getWidth()-4, getHeight()-4, 36, 36);
                } else {
                    g2.setColor(new Color(200, 200, 200, 80));
                    g2.setStroke(new BasicStroke(2f));
                    g2.drawRoundRect(2, 2, getWidth()-4, getHeight()-4, 36, 36);
                }
                g2.dispose();
                super.paintComponent(g);
            }
        };
        adminPanel.setOpaque(false);
        adminPanel.setBounds(centerX, centerY, boxW, boxH);
        adminPanel.setLayout(new BorderLayout());
        JLabel adminLabel = new JLabel("Admin", SwingConstants.CENTER);
        adminLabel.setFont(new Font("Montserrat", Font.BOLD, 28));
        adminPanel.add(adminLabel, BorderLayout.CENTER);
        adminPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(signInCard, "Admin clicked!");
            }
            public void mouseEntered(MouseEvent e) {
                adminPanel.setBackground(new Color(220, 220, 220, 255));
                adminPanel.getRootPane().repaint();
                adminHovered[0] = true;
                adminPanel.repaint();
            }
            public void mouseExited(MouseEvent e) {
                adminPanel.setBackground(new Color(240, 240, 240, 230));
                adminPanel.getRootPane().repaint();
                adminHovered[0] = false;
                adminPanel.repaint();
            }
        });
        signInCard.add(adminPanel);

        // User Panel with hover effect
        final boolean[] userHovered = {false};
        JPanel userPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(userHovered[0] ? new Color(170, 170, 170, 255) : new Color(200, 200, 200, 230));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 36, 36);
                if (userHovered[0]) {
                    g2.setColor(new Color(120, 120, 120, 120));
                    g2.setStroke(new BasicStroke(4f));
                    g2.drawRoundRect(2, 2, getWidth()-4, getHeight()-4, 36, 36);
                } else {
                    g2.setColor(new Color(160, 160, 160, 80));
                    g2.setStroke(new BasicStroke(2f));
                    g2.drawRoundRect(2, 2, getWidth()-4, getHeight()-4, 36, 36);
                }
                g2.dispose();
                super.paintComponent(g);
            }
        };
        userPanel.setOpaque(false);
        userPanel.setBounds(centerX + boxW + boxGap, centerY, boxW, boxH);
        userPanel.setLayout(new BorderLayout());
        JLabel userLabel = new JLabel("User", SwingConstants.CENTER);
        userLabel.setFont(new Font("Montserrat", Font.BOLD, 28));
        userPanel.add(userLabel, BorderLayout.CENTER);
        userPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        userPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(signInCard, "User clicked!");
            }
            public void mouseEntered(MouseEvent e) {
                userPanel.setBackground(new Color(170, 170, 170, 255));
                userPanel.getRootPane().repaint();
                userHovered[0] = true;
                userPanel.repaint();
            }
            public void mouseExited(MouseEvent e) {
                userPanel.setBackground(new Color(200, 200, 200, 230));
                userPanel.getRootPane().repaint();
                userHovered[0] = false;
                userPanel.repaint();
            }
        });
        signInCard.add(userPanel);

        // Already have an account? LOGIN (centered, bold, button-like, with improved hover and color)
        JPanel loginPanel = new JPanel();
        loginPanel.setOpaque(false);
        loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        loginPanel.setBounds(0, centerY + boxH + 60, cardW, 50);
        JLabel loginText = new JLabel("Already have an account? ");
        loginText.setFont(new Font("Montserrat", Font.PLAIN, 21));
        loginText.setForeground(Color.BLACK);
        loginPanel.add(loginText);
        JLabel loginLink = new JLabel("LOGIN");
        loginLink.setFont(new Font("Montserrat", Font.BOLD, 25));
        loginLink.setForeground(new Color(230, 57, 89)); // #e63959
        loginLink.setOpaque(true);
        loginLink.setBackground(new Color(255,255,255,220));
        loginLink.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 57, 89), 2, true),
            new EmptyBorder(4, 22, 4, 22)));
        loginLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginLink.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(signInCard, "Login clicked!");
            }
            public void mouseEntered(MouseEvent e) {
                loginLink.setBackground(new Color(230, 57, 89));
                loginLink.setForeground(Color.WHITE);
                loginLink.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(230, 57, 89), 2, true),
                    new EmptyBorder(4, 22, 4, 22)));
                loginLink.repaint();
            }
            public void mouseExited(MouseEvent e) {
                loginLink.setBackground(new Color(255,255,255,220));
                loginLink.setForeground(new Color(230, 57, 89));
                loginLink.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(230, 57, 89), 2, true),
                    new EmptyBorder(4, 22, 4, 22)));
                loginLink.repaint();
            }
        });
        loginPanel.add(loginLink);
        signInCard.add(loginPanel);

        cardPanel.add(heroSection, "HOME");
        cardPanel.add(pricingCard, "PRICING");
        cardPanel.add(aboutCard, "ABOUT");
        cardPanel.add(signInCard, "SIGNIN");
        add(cardPanel, BorderLayout.CENTER);

        // Navigation click listeners
        homeLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(cardPanel, "HOME");
                homeLabel.setForeground(new Color(230, 57, 89));
                pricingLabel.setForeground(Color.BLACK);
                aboutLabel.setForeground(Color.BLACK);
                signInLabel.setForeground(new Color(230, 57, 89));
            }
        });
        pricingLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(cardPanel, "PRICING");
                homeLabel.setForeground(Color.BLACK);
                pricingLabel.setForeground(new Color(230, 57, 89));
                aboutLabel.setForeground(Color.BLACK);
                signInLabel.setForeground(new Color(230, 57, 89));
            }
        });
        aboutLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(cardPanel, "ABOUT");
                homeLabel.setForeground(Color.BLACK);
                pricingLabel.setForeground(Color.BLACK);
                aboutLabel.setForeground(new Color(230, 57, 89));
                signInLabel.setForeground(new Color(230, 57, 89));
            }
        });
        signInLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(cardPanel, "SIGNIN");
                homeLabel.setForeground(Color.BLACK);
                pricingLabel.setForeground(Color.BLACK);
                aboutLabel.setForeground(Color.BLACK);
                signInLabel.setForeground(new Color(230, 57, 89));
            }
        });

        // Make Get Started button open Sign In card
        getStartedButton.addActionListener(e -> {
            cardLayout.show(cardPanel, "SIGNIN");
            homeLabel.setForeground(Color.BLACK);
            pricingLabel.setForeground(Color.BLACK);
            aboutLabel.setForeground(Color.BLACK);
            signInLabel.setForeground(new Color(230, 57, 89));
        });
    }

    public JButton getGetStartedButton() { return getStartedButton; }
    public JButton getSignInButton() { return signInButton; }

    // Helper method to show EsewaC.jpg in a custom popup
    private void showEsewaPopup() {
        JDialog dialog = new JDialog(this, "Esewa Payment", true);
        dialog.setSize(444, 539); // 60% of 740x899
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(this);
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(Color.WHITE);
        content.setBorder(new EmptyBorder(16, 16, 16, 16));

        // Load and add the image
        try {
            BufferedImage esewaImg = null;
            java.net.URL esewaUrl = getClass().getResource("/Imagepicker/esewaC.jpg");
            if (esewaUrl != null) {
                esewaImg = ImageIO.read(esewaUrl);
            } else {
                java.io.InputStream is = getClass().getResourceAsStream("/Imagepicker/esewaC.jpg");
                if (is != null) esewaImg = ImageIO.read(is);
            }
            if (esewaImg != null) {
                int imgW = 400, imgH = (int)(esewaImg.getHeight() * (400.0 / esewaImg.getWidth()));
                Image scaled = esewaImg.getScaledInstance(imgW, imgH, Image.SCALE_SMOOTH);
                JLabel imgLabel = new JLabel(new ImageIcon(scaled));
                imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                content.add(imgLabel);
            } else {
                JLabel imgLabel = new JLabel("[esewaC.jpg not found]");
                imgLabel.setForeground(Color.RED);
                imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                content.add(imgLabel);
            }
        } catch (Exception ex) {
            JLabel imgLabel = new JLabel("[Failed to load esewaC.jpg]");
            imgLabel.setForeground(Color.RED);
            imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            content.add(imgLabel);
        }

        content.add(Box.createVerticalStrut(18));

        // Phone number input
        JLabel numberLabel = new JLabel("Esewa Phone Number (10 digits):");
        numberLabel.setFont(new Font("Montserrat", Font.PLAIN, 15));
        numberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField numberField = new JTextField();
        numberField.setMaximumSize(new Dimension(300, 32));
        numberField.setFont(new Font("Montserrat", Font.PLAIN, 15));
        numberField.setHorizontalAlignment(JTextField.CENTER);
        content.add(numberLabel);
        content.add(Box.createVerticalStrut(6));
        content.add(numberField);
        content.add(Box.createVerticalStrut(14));

        // Transaction date input (modern: date picker)
        JLabel dateLabel = new JLabel("Transaction Date:");
        dateLabel.setFont(new Font("Montserrat", Font.PLAIN, 15));
        dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(dateLabel);
        content.add(Box.createVerticalStrut(6));

        // Use JSpinner as a date picker (since no external picker is detected)
        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner dateSpinner = new JSpinner(dateModel);
        dateSpinner.setMaximumSize(new Dimension(180, 32));
        dateSpinner.setFont(new Font("Montserrat", Font.PLAIN, 15));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(dateEditor);
        ((JSpinner.DefaultEditor)dateSpinner.getEditor()).getTextField().setHorizontalAlignment(JTextField.CENTER);
        content.add(dateSpinner);
        content.add(Box.createVerticalStrut(18));

        // Submit button
        JButton submitBtn = new JButton("Submit");
        submitBtn.setFont(new Font("Montserrat", Font.BOLD, 16));
        submitBtn.setBackground(new Color(230, 57, 89));
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFocusPainted(false);
        submitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitBtn.setMaximumSize(new Dimension(140, 36));
        content.add(submitBtn);

        // Validation and action
        submitBtn.addActionListener(e -> {
            String number = numberField.getText().trim();
            java.util.Date selectedDate = (java.util.Date) dateSpinner.getValue();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = sdf.format(selectedDate);
            if (!number.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(dialog, "Please enter a valid 10-digit Esewa phone number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Optionally, check if the date is not in the future
            java.util.Date today = new java.util.Date();
            if (selectedDate.after(today)) {
                JOptionPane.showMessageDialog(dialog, "Transaction date cannot be in the future.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(dialog, "Payment details submitted!\nDate: " + formattedDate, "Success", JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        });

        JScrollPane scrollPane = new JScrollPane(content, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(null);
        dialog.setContentPane(scrollPane);
        dialog.setVisible(true);
    }
} 