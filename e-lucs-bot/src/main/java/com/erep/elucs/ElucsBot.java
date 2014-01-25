package com.erep.elucs;

import com.erep.elucs.cmd.*;
import com.erep.elucs.jpa.domain.ErepUser;
import com.erep.elucs.jpa.service.ErepUserService;
import com.erep.elucs.jpa.service.ErepUserServiceImpl;
import org.pircbotx.PircBotX;
import org.pircbotx.User;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ConnectEvent;
import org.pircbotx.hooks.events.NoticeEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class ElucsBot {


    private static final Logger LOG = LoggerFactory.getLogger(ElucsBot.class);
    public static final int MESSAGE_DELAY = 250;


    private final PircBotX botX;

    final ErepUserService erepUserService;

    public ElucsBot(ErepUserService erepUserService) {
        this.erepUserService = erepUserService;
        botX = new PircBotX() {
            @Override
            public void log(String line) {
                if (verbose) {
                    LOG.debug(line);
                }
            }
        };
        botX.setMessageDelay(MESSAGE_DELAY);
        botX.setVerbose(true);
        botX.setAutoReconnect(true);

        initCommands(erepUserService);

    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("simple-repository-context.xml");
        ErepUserServiceImpl userService = context.getBean(ErepUserServiceImpl.class);
        displayRegisteredUsers(userService);
        ElucsBot elucsBot = new ElucsBot(userService);
        elucsBot.start();
    }

    private static void displayRegisteredUsers(ErepUserServiceImpl userService) {
        Iterable<ErepUser> all = userService.findAll();
        LOG.debug("Registered users : ");
        for (ErepUser user : all) {
            LOG.debug(user.toString());
        }
    }

    private void start() {
        botX.setName("e-lucs");

        botX.getListenerManager().addListener(new ListenerAdapter() {

            @Override
            public void onPrivateMessage(PrivateMessageEvent event) throws Exception {
                treatPrivteMessage(event);
            }

            @Override
            public void onNotice(NoticeEvent event) throws Exception {
                treatNotice(event);
            }

            @Override
            public void onConnect(ConnectEvent event) throws Exception {
                botX.identify("erepublik.com");
            }
        });

        try {
            botX.connect("irc.rizon.net");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void treatPrivteMessage(PrivateMessageEvent event) {
        String message = event.getMessage();
        int startSpace = message.indexOf(" ");
        if (startSpace > 0) {
            String channel = message.substring(0, startSpace);
            botX.sendMessage(channel, message.substring(startSpace + 1));
        }
    }

    private void treatNotice(NoticeEvent event) {
        User user = event.getUser();
        String message = event.getMessage();
        if (user.getNick().equals("NickServ") && message.contains("Password accepted")) {
            botX.joinChannel("#elucstest");
            botX.joinChannel("#lu-pub");
            botX.joinChannel("#lu-global");
            botX.joinChannel("#legiunea.umbre");
        }
    }

    private void initCommands(ErepUserService erepUserService) {
        List<AbstractCmd> commands = new ArrayList<AbstractCmd>();

        HelpCmd helpCmd = new HelpCmd(botX, commands);
        commands.add(helpCmd);

        RegisterCmd regCmd = new RegisterCmd(botX, erepUserService);
        commands.add(regCmd);

        ProfileInfoCmd profileInfoCmd = new ProfileInfoCmd(botX, erepUserService);
        commands.add(profileInfoCmd);

        MedalsInfoCmd medalsInfoCommand = new MedalsInfoCmd(botX, erepUserService);
        commands.add(medalsInfoCommand);

        TopInfoCmd topInfoCmd = new TopInfoCmd(botX, erepUserService);
        commands.add(topInfoCmd);

        MuInfoCmd muInfoCmd = new MuInfoCmd(botX, erepUserService);
        commands.add(muInfoCmd);

        AvatarInfoCmd avatarInfoCmd = new AvatarInfoCmd(botX, erepUserService);
        commands.add(avatarInfoCmd);

        AboutInfoCmd aboutInfoCmd = new AboutInfoCmd(botX, erepUserService);
        commands.add(aboutInfoCmd);

        PaperInfoCmd paperInfoCmd = new PaperInfoCmd(botX, erepUserService);
        commands.add(paperInfoCmd);

        PartyInfoCmd partyInfoCmd = new PartyInfoCmd(botX, erepUserService);
        commands.add(partyInfoCmd);

        LinkCmd linkCmd = new LinkCmd(botX, erepUserService);
        commands.add(linkCmd);

        FireCountCmd fcCmd = new FireCountCmd(botX, erepUserService);
        commands.add(fcCmd);

        DonateCmd donateCmd = new DonateCmd(botX, erepUserService);
        commands.add(donateCmd);

        RankUpCmd rankUpCmd = new RankUpCmd(botX, erepUserService);
        commands.add(rankUpCmd);

        BattleCmd battleCmd = new BattleCmd(botX);
        commands.add(battleCmd);

        ExchangeCmd exchangeCmd = new ExchangeCmd(botX);
        commands.add(exchangeCmd);

        SetOrdCmd setOrdCmd = new SetOrdCmd(botX);
        commands.add(setOrdCmd);

        OrdersCmd ordersCmd = new OrdersCmd(botX, setOrdCmd);
        commands.add(ordersCmd);

        EconCmd econCmd = new EconCmd(botX);
        commands.add(econCmd);

        SearchCmd searchCmd = new SearchCmd(botX);
        commands.add(searchCmd);

        CountryCmd countryCmd = new CountryCmd(botX);
        commands.add(countryCmd);

        WeaponCmd weaponCmd = new WeaponCmd(botX);
        commands.add(weaponCmd);

        FoodCmd foodCmd = new FoodCmd(botX);
        commands.add(foodCmd);

        WrmCmd wrmCmd = new WrmCmd(botX);
        commands.add(wrmCmd);

        FrmCmd frmCmd = new FrmCmd(botX);
        commands.add(frmCmd);

        CallCmd callCmd = new CallCmd(botX);
        commands.add(callCmd);
    }


}
