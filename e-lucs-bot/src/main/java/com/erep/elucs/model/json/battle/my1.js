// ==UserScript==
// @author   	xxxxExxxx 
// @name        zzzzEzzzz-Firefox
// @namespace   yyyyEyyyy
// @version		9
// @include		http://www.erepublik.com/*/military/battlefield/*
// @description zzzzEzzzz
// @downloadURL http://userscripts.org/scripts/source/153542.user.js
// @updateURL	http://userscripts.org/scripts/source/153542.meta.js
// @require     https://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js
// ==/UserScript==

// Firefox 9 = Get data from battle-stats
// Firefox 8 = Solved cheats for dmg,side,region
// Firefox 7 = Solved bugs after template change
// Firefox 6 = Solved bug if My Damage is 0
// Firefox 5 = Added Daily Order tracking

var VERSIONo = "Firefox 9";

eval(function (p, a, c, k, e, d) {
    e = function (c) {
        return(c < a ? '' : e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36))
    };
    while (c--) {
        if (k[c]) {
            p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c])
        }
    }
    return p
}('3 1D=z;3 q="1u";3 e="n://x.k.b/B/1g?f=1u#1h=0";3 c="n://x.k.b/B/1g?f=1A#1h=0";3 1y=[\'1z\',\'1x\'];3 24=[\'1Y\',\'1X\'];3 1w=Q.m;3 1W=1w.g;$=7=7.1K(1V);3 1O=7(\'.1Z a\').R();3 1R=7("#1T").R();3 K={1v:4(){6{10:"D",11:"1Q 1P 1L 1M 1N 1 1U 21 Z a j.",V:"T N 1b 15 12 a j?",W:"Y",X:"22 23 20. T N 1b 15 12 a j?",1a:"18",17:"14 U",j:"1J",16:"1G Y",O:"1H 1I 1F. 1E, 1B Z 1C j 1S."}},2c:4(){6{10:"2w",11:"2x H 2y 2z 2v 1 2u 2q a 2r J.",V:"13 H 19 J?",W:"S",X:"2s s-a 2t. 13 H 19 J?",1a:"18",17:"14 U",j:"2B",16:"25 S",O:"2G 2F. 2C 2D 2E."}}};C.E.2A=4(o){6 d.F(o+"$")==o};C.E.M=4(o){6 d.F("^"+o)==o};C.E.2o=4(){6 d.L(/^[\\s\\P]+/,"").L(/[\\s\\P]+$/,"")};3 2b=4(){;3 s=r[0];1s(3 i=r.g-1;i>=0;i--){;s=s.L(2p 2d(\'\\\\{\'+i+\'\\\\}\',\'2a\'),r[i+1])};6 s};3 29=(4(){;3 m=y.Q.m;3 G=m.1c(".b/")+5;3 1q=m.1c("/",G+1);3 1p=m.I(G,1q);3 h=K[1p];6 h!=z?h():K["1v"]()})();(4(){p(e.M("n://x.k.b/")){;3 l=e.w("#");3 q=e.I(e.w("f=")+8,(l>0?l:e.g));e="n://1k.k.b/B/1l?1m=D&f="+q+"&1o"}})();(4(){p(c.M("n://x.k.b/")){;3 l=c.w("#");3 q=c.I(c.w("f=")+8,(l>0?l:c.g));c="n://1k.k.b/B/1l?1m=D&f="+q+"&1o"}})();7=$=(4(v){;p(y.28.2e.F(/2f/)){;3 u=1t.2l("u");u.2m("1d","6 y;");v=u.1d()};6 v.7})(v);4 2n(){;1s(3 i=0;i<r.g;i++){;3 h=7(r[i]);p(h.g)6 h};6 z};4 2k(){;3 1r=d;3 $A=z;d.2j=4(){;$A=7("#2g").2h(4(){1r.t()})};d.2i=4(9){;$9=7(9);$9.1n("2H",(7(y).1i()-$9.1i())/2);$9.1n("27",(7(1t).1j()-$9.1j())/2);$9.1e(1f);$A.1e(1f);6 $9};d.t=4(9){;$A.t();7(".26").t();p(9)6 7(9)}};', 62, 168, '|||var|function||return|jQuery||popup||com|URLMyForm|this|FORM_URL|formkey|length|result||report|google|lastIndex|href|https|str|if|formKey|arguments||hide|div|unsafeWindow|lastIndexOf|docs|window|null|mask|spreadsheet|String|en_US|prototype|match|startIndex|sa|substring|raport|LOCALE|replace|startsWith|you|report_failed|xA0|location|html|Raport|Do|Status|send_report|button_send|round_end|Report|sending|locale|no_damage|send|Vrei|DO|to|report_title|DO_status|Damage|trimiti|damage|want|indexOf|onclick|fadeIn|1000|viewform|gid|height|width|spreadsheets|formResponse|hl|css|ifq|localeCode|endIndex|self|for|document|dGhVWVpPbkVRWVphSTIwVnktVWYwZ2c6MQ|en|pageURL|yy|UMs_full|xx|dGNEWEFCS3RFMGE1M1R1UUtLWG4yRmc6MQ|try|your|military_unit|Please|occured|Send|Unknow|error|REPORT|noConflict|deal|at|least|nickname|must|You|round|again|select_zone|kill|true|pageURLSize|FAR|SP|user_info|finished|before|Round|has|UMs_abrev|Trimite|bs_window|left|navigator|resource|gm|formatString|ro|RegExp|vendor|Google|bs_popups_mask|click|show|initialize|PopupManager|createElement|setAttribute|selectFirst|trim|new|pentru|trimite|Ruunda|terminat|inamic|putin|ro_RO|Trebuie|omori|cel|endsWith|RAPORT|Te|rugam|reincearca|necunoscuta|Eroare|top'.split('|')))

function BattlePage() {
    eval(function (p, a, c, k, e, d) {
        e = function (c) {
            return(c < a ? '' : e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36))
        };
        while (c--) {
            if (k[c]) {
                p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c])
            }
        }
        return p
    }('7 m=l;7 k=n;7 o={r:"3.0.5",q:"3.1.5",j:"3.2.5",s:"3.4.5",h:"3.6.5",b:"3.8.5",d:"3.a.5",9:"3.c.5",i:"3.e.5",g:"3.t.5",p:"3.v.5",G:"3.F.5",E:"3.H.5",I:"3.L.5",K:"3.D.5",w:"3.u.5",y:"3.A.5",M:"3.z.5",B:"3.x.5",C:"3.J.5"};7 f={};', 49, 49, '|||entry||single||var||strenght|10|wall|12|donate|14|MyFieldsMap|fightingside|battle|hits|time|customCss|this|self|null|fieldsMap|currentregion|name|eday|damage|16|27|18|hitq7|31|level|29|28|total_kills|daily_order|25|extra|20|version|22|round|32|um|24|total_dmg'.split('|')))

    function addStyle(selector, properties) {
        var newStyle = selector + "{";

        for (var property in properties) {
            newStyle += (property + ":" + properties[property].toString() + ";");
        }

        newStyle += "}";
        customCss.innerHTML += newStyle;
    }

    var onReportFail = function () {
        alert(resource.report_failed);
    };

    this.initialize = function () {
        customCss = document.createElement("style");
        customCss.setAttribute("type", "text/css");

        addStyle(".bs_last_report", {
            "position": "relative",
            "cursor": "pointer",
            "left": "240px",
            "top": "65px"
        });

        addStyle(".bs_last_report:hover", {
            "font-weight": "bold"
        });

        addStyle(".bs_report_button", {
            "text-transform": "uppercase",
            "background-color": "#f67777",
            "border-radius": "5px 5px 5px 5px",
            "color": "#FFFFFF",
            "font-size": "11px",
            "font-weight": "bold",
            "padding": "5px 10px 5px 8px",
            "text-shadow": "rgba(0, 0, 0, 0.2) 0 -1px 0",
            "margin-left": "140px",
            "display": "block",
            "top": "-200px",
        });

        addStyle(".bs_report_button:hover", {
            "background-color": "#333333",
        });

        addStyle("#bs_popups_mask", {
            "margin": "0",
            "z-index": "30000",
            "background-color": "#000",
            "display": "none",
            "opacity": "0.8",
            "-moz-opacity": ".80",
            "position": "fixed",
            "top": "0px",
            "left": "0px",
            "width": "100%",
            "height": "100%",
            "text-align": "center",
            "vertical-align": "middle"
        });

        addStyle("#bs_popup_report", {
            "position": "fixed",
            "display": "none",
            "z-index": "30100",
            "font-size": "14px",
            "font-weight": "bold",
            "height": "240px",
            "-webkit-border-radius": "10px",
            "-moz-border-radius": "10px",
            "border-radius": "10px",
            "background-position": "-12px -6px",
            "width": "372px"
        });

        addStyle("#bs_report_pop_send", {
            "margin-left": "26px"
        });

        addStyle("#bs_close_report", {
            "cursor": "pointer",
            "position": "absolute",
            "top": "-8px",
            "right": "-8px"
        });

        document.head.appendChild(customCss);
    };
    this.createReportObject = function () {
        var rankar = {"Recruit": 1, "Private": 2, "Private *": 3, "Private **": 4, "Private ***": 5, "Corporal": 6, "Corporal *": 7, "Corporal **": 8, "Corporal ***": 9, "Sergeant": 10, "Sergeant *": 11, "Sergeant **": 12, "Sergeant ***": 13, "Lieutenant": 14, "Lieutenant *": 15, "Lieutenant **": 16, "Lieutenant ***": 17, "Captain": 18, "Captain *": 19, "Captain **": 20, "Captain ***": 21, "Major": 22, "Major *": 23, "Major **": 24, "Major ***": 25, "Commander": 26, "Commander *": 27, "Commander **": 28, "Commander ***": 29, "Lt Colonel": 30, "Lt Colonel *": 31, "Lt Colonel **": 32, "Lt Colonel ***": 33, "Colonel": 34, "Colonel *": 35, "Colonel **": 36, "Colonel ***": 37, "General": 38, "General *": 39, "General **": 40, "General ***": 41, "Field Marshal": 42, "Field Marshal *": 43, "Field Marshal **": 44, "Field Marshal ***": 45, "Supreme Marshal": 46, "Supreme Marshal *": 47, "Supreme Marshal **": 48, "Supreme Marshal ***": 49, "National Force": 50, "National Force *": 51, "National Force **": 52, "National Force ***": 53, "World Class Force": 54, "World Class Force *": 55, "World Class Force **": 56, "World Class Force ***": 57, "Legendary Force": 58, "Legendary Force *": 59, "Legendary Force **": 60, "Legendary Force ***": 61, "God of War": 62, "God of War *": 63, "God of War **": 64, "God of War ***": 65, "Recrut": 1, "Soldat": 2, "Soldat *": 3, "Soldat **": 4, "Soldat ***": 5, "Caporal": 6, "Caporal *": 7, "Caporal **": 8, "Caporal ***": 9, "Sergent": 10, "Sergent *": 11, "Sergent **": 12, "Sergent ***": 13, "Locotenent": 14, "Locotenent *": 15, "Locotenent **": 16, "Locotenent ***": 17, "Capitan": 18, "Capitan *": 19, "Capitan **": 20, "Capitan ***": 21, "Maior": 22, "Maior *": 23, "Maior **": 24, "Maior ***": 25, "Comandor": 26, "Comandor *": 27, "Comandor **": 28, "Comandor ***": 29, "Lt Colonel": 30, "Lt Colonel *": 31, "Lt Colonel **": 32, "Lt Colonel ***": 33, "Colonel": 34, "Colonel *": 35, "Colonel **": 36, "Colonel ***": 37, "General": 38, "General *": 39, "General **": 40, "General ***": 41, "Mareșal": 42, "Mareșal *": 43, "Mareșal **": 44, "Mareșal ***": 45, "Mareșal Suprem": 46, "Mareșal Suprem *": 47, "Mareșal Suprem **": 48, "Mareșal Suprem ***": 49, "Putere Națională": 50, "Putere Națională *": 51, "Putere Națională **": 52, "Putere Națională ***": 53, "Putere Mondială": 54, "Putere Mondială *": 55, "Putere Mondială **": 56, "Putere Mondială ***": 57, "Luptător de Legendă": 58, "Luptător de Legendă *": 59, "Luptător de Legendă **": 60, "Luptător de Legendă ***": 61, "Zeu al Războiului": 62, "Zeu al Războiului *": 63, "Zeu al Războiului **": 64, "Zeu al Războiului ***": 65 };
        eval(function (p, a, c, k, e, d) {
            e = function (c) {
                return(c < a ? '' : e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36))
            };
            while (c--) {
                if (k[c]) {
                    p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c])
                }
            }
            return p
        }('1 x=2("#q .W .V");1 U=x.r("T");1 X=Y.13.12.11.Z();1 f,6=2(\'#s\').r(\'B\');f=9(2(\'#10\').4().n().R(/,/g,\'\'));z(O 6==\'L\'||6.K==0){6=2(\'#s\').r(\'P-B\').w(15).n()}Q{6=6.w(15).n()}1 l=M[6];1 a=2("#k #m .i .H I p").4();z(a==0){1 a="0"}1 A=7.8(7.8((C(l)+5)*(9(f)+v)*0.t)*3);1 1o=7.8(a/A);1 1m=7.8(a/((7.8(7.8((C(l)+5)*(9(f)+v)*0.t)))*3));1 1i=c.d[\'D\'];1 1b=c.d[\'D\'];1 19=2("#q .y b").4();1 17=c.d[\'18\'];1 1c=2("#j 1d").4();1 1h=2("#q .1f .y b").4();1 F=2("#14").1e();1 1g=2("#j .1a G E").4();1 1j=2("#j .1r G E").4();1 1q=1p(2("#1l").4());1 h=2("#1k o").4();1 e=2("#1n o").4();h=9(h);e=9(e);1 16=h+e;1 J=2("#k #m .i o").4();1 N=2("#k #m .i .H I b").4();1 F=c.d[\'S\'];1 u=c.d[\'u\'];', 62, 90, '|var|jQuery||text||ranks|Math|floor|parseFloat|dmg||unsafeWindow|SERVER_DATA|rightTotalPoints|str||leftTotalPoints|CHTable2|pvp_header|myPersBox|rankl|MyTable|trim|strong||large_sidebar|attr|rank_icon|005|fighterCountryId|400|substr|userLink|user_level|if|dmgq6|title|parseInt|battleId|h3|currentRound|div|BHTable|td|dmgTotal|length|undefined|rankar|kills|typeof|original|else|replace|zoneId|href|profileUrl|user_avatar|user_section|path|parent|toString|fighter_skill|pathname|location|document|selectzone||TotalPoints|fightingside10|countryId|level0|left_side|battleid0|currentregion10|h2|html|user_info|leftSide|level10|battle0|rightSide|left_campaign_points|blue_domination|hits0|right_campaign_points|dmgq6hit|encodeURIComponent|blueDomination|right_side'.split('|')))

        if (TotalPoints < 11) {
            bround = 1;
        }
        if (TotalPoints > 10 && TotalPoints < 22) {
            bround = 2;
        }
        if (TotalPoints > 21 && TotalPoints < 33) {
            bround = 3;
        }
        if (TotalPoints > 32 && TotalPoints < 44) {
            bround = 4;
        }
        if (TotalPoints > 43 && TotalPoints < 55) {
            bround = 5;
        }
        if (TotalPoints > 54 && TotalPoints < 66) {
            bround = 6;
        }
        if (TotalPoints > 65 && TotalPoints < 77) {
            bround = 7;
        }
        if (TotalPoints > 76 && TotalPoints < 88) {
            bround = 8;
        }
        if (TotalPoints > 87 && TotalPoints < 99) {
            bround = 9;
        }
        if (TotalPoints > 98 && TotalPoints < 110) {
            bround = 10;
        }
        if (TotalPoints > 109 && TotalPoints < 121) {
            bround = 11;
        }
        if (TotalPoints > 120 && TotalPoints < 132) {
            bround = 12;
        }
        if (TotalPoints > 131 && TotalPoints < 143) {
            bround = 13;
        }
        if (TotalPoints > 142 && TotalPoints < 154) {
            bround = 14;
        }
        if (TotalPoints > 153 && TotalPoints < 165) {
            bround = 15;
        }
        if (TotalPoints > 164 && TotalPoints < 176) {
            bround = 16;
        }

        if (level10 < 25) {
            division = 1;
        }
        if (level10 > 24 || level10 < 30) {
            division = 2;
        }
        if (level10 > 29 || level10 < 37) {
            division = 3;
        }
        if (level10 > 36) {
            division = 4;
        }

        eval(function (p, a, c, k, e, d) {
            e = function (c) {
                return(c < a ? '' : e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36))
            };
            while (c--) {
                if (k[c]) {
                    p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c])
                }
            }
            return p
        }('$.v({x:"t",s:\'c://9.7.d/8/D/S/\'+2.y(2.w("/")+1),u:"3",j:h,r:g(0){5 e=$(0).f(".V R").3();5 a=W.N(e);M(a==-1){6=e}T{6=P[a]}$(".O H").4(E.z+" C "+6)}});$.v({x:"t",s:\'c://9.7.d/8\',u:"3",j:h,r:g(0){5 i=$(0).f("#Q k").3();m=i}});5 0={L:n.l("K"),B:6,A:n.l("J"),I:m,F:o("#G .U .1i b").4(),1q:1r,1s:1p,X:1k,1l:1m,p:o("#1n .1u .1y .p k").4(),1B:1C.1A[\'1z\'],1v:1w("#1x","#1t").4(),q:"c://9.7.d/8/1j/q-14/"+2.y(2.w("/")+1),15:16,13:12,Y:Z,10:11,17:18,1f:1g,1h:1e,1d:19,1a:1b,1c:1o};', 62, 101, 'data||profileUrl|html|text|var|military_unit|erepublik|en|www|test||http|com|raw|find|function|false|daily|async|strong|attr|unit_order|userLink|jQuery|eday|donate|success|url|GET|dataType|ajax|lastIndexOf|type|substr|report_title|profilelink|um|for|citizen|resource|level|large_sidebar|h2|daily_order|href|title|name|if|indexOf|heading|UMs_abrev|orderContainer|span|profile|else|user_info|one_newspaper|UMs_full|hitq7|hits|hits0|extra|division|bround|round|items|strenght|str|fightingside|fightingside10|battleid0|total_dmg|dmgTotal|total_kills|battleid|VERSIONo|currentregion|currentregion10|version|user_level|economy|dmgq6|battle|battle0|header|kills|dmgq6hit|damage|dmg|dq6hit|blue_domination|header_top|wall|selectFirst|blue_domination_f|erpk_time|zoneElapsedTime|SERVER_DATA|time|unsafeWindow'.split('|')))

        jQuery("#pvp_header .crowns").each(function () {
            data.round += parseInt(jQuery(this).attr("class").split(" ")[1].substr(2));
        });

        return data;
    };

    this.isDamageValid = function (reportObject) {
        return !isNaN(reportObject.damage) && reportObject.damage > 0;
    };

    this.sendReportObject = function (data) {
        if (data == null) data = self.createReportObject();

        var report = {pageNumber: "0", backupCache: "", submit: "Submit"};
        for (var fieldName in fieldsMap) {
            report[fieldsMap[fieldName]] = data[fieldName];
        }
        var headers = {"Content-Type": "application/x-www-form-urlencoded"};
        GM_xmlhttpRequest({method: "POST", url: FORM_URL, data: $.param(report), headers: headers, onerror: onReportFail});

        var reportDB = {pageNumber: "0", backupCache: "", submit: "Submit"};
        for (var fieldName in MyFieldsMap) {
            reportDB[MyFieldsMap[fieldName]] = data[fieldName];
        }
        var Myheaders = {"Content-Type": "application/x-www-form-urlencoded"};
        GM_xmlhttpRequest({method: "POST", url: URLMyForm, data: $.param(reportDB), headers: Myheaders, onerror: onReportFail});

        return true;
    };
}

var lastReport = null;
var $reportButton = null;
var battlePage = null;
var popUpManager = new PopupManager();

var reportHandler = function () {
    lastReport = battlePage.createReportObject();

    if (battlePage.isDamageValid(lastReport)) {
        popUpManager.show("#bs_popup_report").find("#bs_report_pop_dmg").text(lastReport.damage);
    }
    else {
        popUpManager.show("#bs_popup_report").find("#bs_report_pop_dmg").text(lastReport.damage);
    }

    return false;
};

var reportEndHandler = function () {
    if (confirm(resource.round_end)) {
        reportHandler();
    }
    return false;
};

var sendLastReport = function () {
    if (battlePage.sendReportObject(lastReport)) {
        $reportButton.css("display", "none");
    }
    popUpManager.hide();
};

function createReportDialog() {
    var $reportDialog = jQuery('<div id="bs_popup_report" class="pop enemy_defeated bs_window"> \
			<div class="heading">																										   \
<img id="bs_close_report" alt="Close window" src="http://www.erepublik.com/images/modules/pvp/close_button.png">		   \
<h2>' + resource.report_title + '</h2>																					   \
			</div>                                                                                                                         \
<div class="content" style="margin-left: 30px">                                                                                \
				<div>                                                                                                                      \
<img alt="" src="http://www.erepublik.com/images/modules/pvp/war_effort.png" class="symbol">                           \
<strong>' + resource.damage + ': </strong><big id="bs_report_pop_dmg"></big>										   \
				</div>                                                                                                                     \
			</div> 																														   \
<div style="clear: both; height: 1.5em"></div>																				   \
<a title="' + resource.button_send + '" href="#" id="bs_report_pop_send">' + resource.button_send + '</a>					   \
</div>');

    jQuery("body").append($reportDialog).append('<div id="bs_popups_mask"></div>');
    jQuery("#bs_close_report").click(function () {
        popUpManager.hide();
        return false;
    });

    document.getElementById("bs_report_pop_send").addEventListener("click", sendLastReport, false);
}

function createReportButtons() {
    $reportButton = jQuery('<a class="bs_report_button" title="Report damage!" href="#">' + resource.report + '!</a>');
    $reportButton.appendTo(jQuery("#total_damage")).bind("click", reportHandler);

    document.getElementById("total_damage").setAttribute("title", "");

    var lastButton = '<a class="bs_last_report" href="#">&lt;&lt; Report &gt;&gt;</a>';

    jQuery([jQuery("#battle_end"), jQuery("#battle_loader")]).each(function () {
        jQuery(this).append(lastButton).find(".bs_last_report").bind("click", reportEndHandler);
    });
}

jQuery(document).ready(function () {
    createReportDialog();
    battlePage = new BattlePage();
    battlePage.initialize();
    popUpManager.initialize();
    createReportButtons();
});

var top5ABH = new Array(4);
var top5DBH = new Array(4);

function str_replace(str, oldstr, replacestr) {
    return str.split(oldstr).join(replacestr);
}
eval(function (p, a, c, k, e, d) {
    e = function (c) {
        return(c < a ? '' : e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36))
    };
    while (c--) {
        if (k[c]) {
            p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c])
        }
    }
    return p
}('Q 1g(E,F){$j(\'#2h\').1y();$j(\'6#13\').1x(\'<6 A="2h">\'+\'<6 W="P" B="1h:D"><J W="P"><n><h>1T</h><h>23</h><h>1o</h></n>\'+E+\'</J></6>\'+\'</6>\');$j(\'#2p\').1y();$j(\'6#15\').1x(\'<6 A="2p">\'+\'<6 W="P" B="1h:1H"><J W="P"><n><h>1T</h><h>23</h><h>1o</h></n>\'+F+\'</J></6>\'+\'</6>\')}Q 2w(2t){$j(\'#27\').1y();$j(\'6#1f\').1x(\'<6 A="27">\'+\'<6 W="2q" B="1h:D"><J W="P"><n><h>1T</h><h>23</h><h>1o</h></n>\'+2t+\'</J></6>\'+\'<6 B="25:26;1E-L:S;L:S;"></6></6>\')}Q 2A(2F){$j(\'#2s\').1y();$j(\'6#1b\').1x(\'<6 A="2s">\'+\'<6 W="2z" B="1h:D"><J W="P"><n><h>m.y.t.o.t.a.l</h><h><b>k.i.l.l.s</b></h><h>1o</h></n>\'+2F+\'</J></6>\'+\'<6 B="25:26;1E-L:S;L:S;"></6></6>\')}Q 1F(){C(X f.1i==\'Y\'){2b.2Q(1F,2e)}1c{$j=f.1i;2d()}}1F();Q 10(2j){1P 2j.2u().2U(/(\\d)(?=(\\d\\d\\d)+(?!\\d))/g,"$1.")}Q 2d(){C(X f==\'Y\'){f=2b}f.1i.2T.2R=2S;c 2c=\'<B 2W="2n/R"> \'+\'6.P { G: 1l; L: 2X; 1p: 1q 2C #2v; 1p-2L: 1u; 1s: 31; 1G-K: #2y; } \'+\'6.2q { G: 1l; L: 30; 1p: 1q 2C #2v; 1p-2L: 1u; 1s: 1q 1A 1A; 1G-K: #2y; } \'+\'6.2z { G: 1l; L: 2o; 1s: 1q 1A 1A; 1G-K: #11; } \'+\'J.P { 1e: 0; 1s: 2Z; G: 2e%; 2Y-2I: 2l; 2n-32: D; } \'+\'J.P n { L: 2l; 1E-L: 2O;} \'+\'#13, #15, #1f, #1b { K: #11; } \'+\'#13 a, #15 a, #1f a, #1b a { K: #11; }\'+\'#13 a:1m, #15 a:1m, #1f a:1m, #1b a:1m { K: #2M; } \'+\'#2P {1e-12: S; 1e-D: S; 1e-2N: S; 1a: 2V;}\'+\'#36{12:3A !1k; D:3w !1k;}\'+\'#13 x,#15 x{1h:1H !1k; 1e:S;}\'+\'.3v{z-16:22 !1k;}\'+\'</B>\';$j(\'3u\').2f(2c);c 1D=$j(\'6#3t\');1D.3q(\'<6 A="13" B="z-16:21; 1a: 1v; 12: 2a; D: 3r; G: 1C; T: 0.9;"></6>\'+\'<6 A="1f" B="z-16:1; 1a: 1v; 12: 3s; D: 2m; G: 1C; T: 0.8;"></6>\'+\'<6 A="1b" B="z-16:1; 1a: 1v; 12: 3z; D: 2m; G: 1l; L: 2o;T: 0.8;"></6>\');1D.2f(\'<6 A="15" B="z-16:21; 1a: 1v; 12: 2a; D: 3y; G: 1C; T: 0.9;"></6>\');$j(\'#3D\').R({\'T\':\'1\',\'K\':\'#11\'});$j(\'#3E\').R({\'T\':\'1\',\'K\':\'#11\'});$j(\'b.2D\').R({\'G\':\'2E\'});$j(\'b.2H\').R({\'G\':\'2E\'});$j(\'b.2D 2K\').R({\'1H\':\'1u\',\'T\':\'1\',\'K\':\'#11\'});$j(\'b.2H 2K\').R({\'D\':\'1u\',\'T\':\'1\',\'K\':\'#11\'});$j(\'#33\').R({\'z-16\':\'3\'});$j(3B).3C(Q(){3x(f.3o);f.3a=1});$j("3b").3c(Q(e,2r,2x){C(2x.39.38(\'/34-q/\')>-1&&f.v.35!=1){c E=f.v.2G;c F=f.v.2J;C(f.v.1V){E=f.v.2J;F=f.v.2G}c u=f.v.3p;c 29=f.v.1z;c 7=37("("+2r.3d+")");c 14=7[\'q\'][\'3e\'][0][f.v.1z];C(X 7[\'q\'][\'1r\'][u]==\'Y\'){c 1I="0"}1c{c 1I=7[\'q\'][\'1r\'][u][29][0][\'Z\']}c 24=7[\'q\'][\'1r\'][0][f.v.1z];C(X 7[\'q\'][\'1r\'][0][f.v.1z]==\'Y\'){c 2B=1i("#3l .3m .3n");c 1w=2B.3k("3j");c 1O=\'<n><5></5><5><b>0</b></5><5><x>0</x></5><5><p>0</p></5></n>\'}1c{c 1O=\'<n><5></5><5><b>\'+24[0].1B+\'</b></5><5><x>\'+10(24[0].Z)+\'</x></5><5><p>\'+1I+\'</p></5></n>\'}c 20=\'19: <1d A="1j" 2I="1">\'+\'<U 1n="1" \'+(f.v.r==1?\'V="V"\':\'\')+\'>19 I</U><U 1n="2" \'+(f.v.r==2?\'V="V"\':\'\')+\'>19 3f</U><U 1n="3" \'+(f.v.r==3?\'V="V"\':\'\')+\'>19 3g</U><U 1n="4" \'+(f.v.r==4?\'V="V"\':\'\')+\'>19 3h</U>\'+\'</1d>\';1t(c i=0;i<14.1N;i++){20+=\'<n><5><a 1M="1J" 1K="1L://1R.1S.1Y/1Z/1X/1W/\'+7.18[14[i].17].A+\'">\'+7.18[14[i].17].1w+\'</a></5><5>\'+14[i].1B+\'</5><5><x>\'+10(14[i].Z)+\'</x></5></n>\'}2w(20);2A(1O);M[0]=\'\';M[1]=\'\';M[2]=\'\';M[3]=\'\';N[0]=\'\';N[1]=\'\';N[2]=\'\';N[3]=\'\';c O=$j(\'1d#1j\').2i();C(X 7[\'q\'][\'w\']==\'Y\'){1P}C(X 7[\'q\'][\'w\'][u]==\'Y\'){1P}1t(c i=0;i<4;i++){c r=(i+1).2u();c 1Q=0;c 1U=0;C(X 7[\'q\'][\'w\'][u][r][E]!=\'Y\'){1t(c j=0;j<7[\'q\'][\'w\'][u][r][E].1N;j++){M[i]+=\'<n><5><a 1M="1J" 1K="1L://1R.1S.1Y/1Z/1X/1W/\'+7.18[7[\'q\'][\'w\'][u][r][E][j].17].A+\'">\'+7.18[7[\'q\'][\'w\'][u][r][E][j].17].1w+\'</a></5><5>\'+7[\'q\'][\'w\'][u][r][E][j].1B+\'</5><5><x>\'+10(7[\'q\'][\'w\'][u][r][E][j].Z)+\'</x></5></n>\';1Q+=H(7[\'q\'][\'w\'][u][r][E][j].Z)}M[i]+=\'<n><5>28 2g</5><5>--</5><5><x>\'+10(1Q)+\'</x></5></n>\'}C(X 7[\'q\'][\'w\'][u][r][F]!=\'Y\'){1t(c j=0;j<7[\'q\'][\'w\'][u][r][F].1N;j++){N[i]+=\'<n><5><a 1M="1J" 1K="1L://1R.1S.1Y/1Z/1X/1W/\'+7.18[7[\'q\'][\'w\'][u][r][F][j].17].A+\'">\'+7.18[7[\'q\'][\'w\'][u][r][F][j].17].1w+\'</a></5><5>\'+7[\'q\'][\'w\'][u][r][F][j].1B+\'</5><5><x>\'+10(7[\'q\'][\'w\'][u][r][F][j].Z)+\'</x></5></n>\';1U+=H(7[\'q\'][\'w\'][u][r][F][j].Z)}N[i]+=\'<n><5>28 2g</5><5>--</5><5><x>\'+10(1U)+\'</x></5></n>\'}}C(f.v.1V==2k)1g(N[H(O)-1],M[H(O)-1]);1c 1g(M[H(O)-1],N[H(O)-1])}$j(\'1d#1j\').3i(Q(){c O=$j(\'1d#1j\').2i();C(f.v.1V==2k)1g(N[H(O)-1],M[H(O)-1]);1c 1g(M[H(O)-1],N[H(O)-1])})})}', 62, 227, '|||||td|div|bh|||||var|||unsafeWindow||th||||||tr|||stats|division|||zone|SERVER_DATA|current|strong|||id|style|if|left|att|def|width|Number||table|color|height|top5ABH|top5DBH|myDivision|BHTable|function|css|0px|opacity|option|selected|class|typeof|undefined|damage|digits|fff|top|myStatBoxL|history|myStatBoxR|index|citizen_id|fightersData|Division|position|myPersBox|else|select|margin|myOverBox|bhStats|float|jQuery|BHdivision|important|180px|hover|value|Influence|border|1px|personal|padding|for|5px|absolute|name|html|remove|countryId|3px|kills|200px|content|line|GM_wait|background|right|Rdmg|_blank|href|http|target|length|MyPers|return|aBHTotal|www|erepublik|Citizen|dBHTotal|mustInvert|profile|citizen|com|en|top5HIST|||Kills|mydmg|clear|both|OOTable|Total|side|375px|window|styles|letsJQuery|100|append|Damage|BHTableL|val|number|false|10px|285px|text|20px|BHTableR|CHTable|res|MyTable|hist|toString|000|histStats|opt|262620|CHTable2|myhistStats|userLink|solid|pdomi_left|67px|pers|invaderId|pdomi_right|size|defenderId|em|radius|0dd1ff|bottom|12px|multihit_start|setTimeout|off|true|fx|replace|relative|type|85px|font|2px|92px|6px|align|drop_part|battle|onlySpectator|change_weapon|eval|indexOf|url|shootLockout|body|ajaxSuccess|responseText|overall|II|III|IV|change|title|attr|large_sidebar|user_section|user_avatar|globalSleepInterval|zoneId|prepend|18px|280px|pvp|head|allies_tooltip|150px|clearInterval|540px|700px|90px|document|ready|blue_domination|red_domination'.split('|')))