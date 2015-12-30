package com.irrationalstudio.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.irrationalstudio.constants.ApplicationConstants;
import com.irrationalstudio.thefootballmaniac.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Prasad on 12/12/2015.
 */
public class MySharedPreferences {

    private static final String TAG = MySharedPreferences.class.getName();


    public static void saveSeason(Context context, HashMap<String, String> hashMap) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(ApplicationConstants.SEASON_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            editor.putString(entry.getKey(), entry.getValue());
        }

        editor.apply();
    }

    public static ArrayList getSeason(Context context) {
        int i = 0;
        ArrayList<String> arrayList = new ArrayList<>();

        SharedPreferences sharedPreferences = context.getSharedPreferences(ApplicationConstants.SEASON_PREFERENCES, Context.MODE_PRIVATE);

        arrayList.add(i++, sharedPreferences.getString(ApplicationConstants.BUNDESLIGA1, null));
        arrayList.add(i++, sharedPreferences.getString(ApplicationConstants.BUNDESLIGA2, null));
        arrayList.add(i++, sharedPreferences.getString(ApplicationConstants.LIGUE1, null));
        arrayList.add(i++, sharedPreferences.getString(ApplicationConstants.LIGUE2, null));
        arrayList.add(i++, sharedPreferences.getString(ApplicationConstants.PREMIER_LEAGUE, null));
        arrayList.add(i++, sharedPreferences.getString(ApplicationConstants.PRIMERA_DIVISION, null));
        arrayList.add(i++, sharedPreferences.getString(ApplicationConstants.SEGUNDADIVISION, null));
        arrayList.add(i++, sharedPreferences.getString(ApplicationConstants.SERIEA, null));
        arrayList.add(i++, sharedPreferences.getString(ApplicationConstants.PRIMEIRA_LIGA, null));
        arrayList.add(i++, sharedPreferences.getString(ApplicationConstants.BUNDESLIGA3, null));
        arrayList.add(i++, sharedPreferences.getString(ApplicationConstants.EREDIVISIE, null));
        arrayList.add(i, sharedPreferences.getString(ApplicationConstants.CHAMPIONSLEAGUE, null));

        return arrayList;
    }

    public static void setSeasonInfo(Context context, String preferenceName, String key, String value) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(key, value);
        editor.apply();

    }

    public static String getSeasonInfo(Context context, String preferenceName, String key) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);

        return sharedPreferences.getString(key, null);
    }

    public static void setLeagueTableInfo(Context context, String preferenceName, String key, String value) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(key, value);
        editor.apply();

    }

    public static void setTeams(Context context, String preferenceName, String key, String value) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(key, value);
        editor.apply();

    }

    public static void setFixtures(Context context, String preferenceName, String key, String value) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(key, value);
        editor.apply();

    }

    public static HashMap getTeamCrest(String preferenceName) {
        HashMap<String, String> teamCrest = new HashMap<>();

        switch (preferenceName) {

            case ApplicationConstants.BUNDESLIGA_1_PREFERENCES:
                //Bundesliga 1
                teamCrest.put(ApplicationConstants.BAYERN_MUNCHEN, String.valueOf(R.drawable.bayern_munchen));
                teamCrest.put(ApplicationConstants.BORUSSIA_DORTMUND, String.valueOf(R.drawable.borussia_dortmund));
                teamCrest.put(ApplicationConstants.HERTHA_BSC, String.valueOf(R.drawable.hertha));
                teamCrest.put(ApplicationConstants.BOR_MONCHENGLADBACH, String.valueOf(R.drawable.borussia_mc3b6nchengladbach));
                teamCrest.put(ApplicationConstants.BAYER_LEVERKUSEN, String.valueOf(R.drawable.bayer_leverkusen));
                teamCrest.put(ApplicationConstants.FC_SCHALKE, String.valueOf(R.drawable.fc_schalke));
                teamCrest.put(ApplicationConstants.VFL_WOLFSBURG, String.valueOf(R.drawable.vfl_wolfsburg_));
                teamCrest.put(ApplicationConstants.FSV_MAINZ, String.valueOf(R.drawable.fsv_mainz));
                teamCrest.put(ApplicationConstants.FC_KOLN, String.valueOf(R.drawable.fc_koln));
                teamCrest.put(ApplicationConstants.HAMBURGER_SV, String.valueOf(R.drawable.hamburger_sv));
                teamCrest.put(ApplicationConstants.FC_AUGSBURG, String.valueOf(R.drawable.fc_augsburg));
                teamCrest.put(ApplicationConstants.FC_INGOLSTADT, String.valueOf(R.drawable.fc_ingolstadt));
                teamCrest.put(ApplicationConstants.SV_DARMSTADT, String.valueOf(R.drawable.sv_darmstadt));
                teamCrest.put(ApplicationConstants.EINTRACHT_FRANKFURT, String.valueOf(R.drawable.eintracht_frankfurt));
                teamCrest.put(ApplicationConstants.VFB_STUTTGART, String.valueOf(R.drawable.vfb_stuttgart));
                teamCrest.put(ApplicationConstants.WERDER_BREMEN, String.valueOf(R.drawable.werder_bremen));
                teamCrest.put(ApplicationConstants.HANNOVER, String.valueOf(R.drawable.hannover));
                teamCrest.put(ApplicationConstants.TSG_HOFFENHEIM, String.valueOf(R.drawable.hoffenheim));
                break;

            case ApplicationConstants.BUNDESLIGA_2_PREFERENCES:

                //Bundesliga 2
                teamCrest.put(ApplicationConstants.RED_BULL_LEIPZIG, String.valueOf(R.drawable.red_bull_leipzig));
                teamCrest.put(ApplicationConstants.SC_FREIBURG, String.valueOf(R.drawable.sc_freiburg));
                teamCrest.put(ApplicationConstants.FC_NURNBERG, String.valueOf(R.drawable.fc_nuremberg));
                teamCrest.put(ApplicationConstants.FC_PAULI, String.valueOf(R.drawable.fc_st_pauli));
                teamCrest.put(ApplicationConstants.EINTRACHT_BRAUNSCHWEIG, String.valueOf(R.drawable.eintracht_braunschweig));
                teamCrest.put(ApplicationConstants.SV_SANDHAUSEN, String.valueOf(R.drawable.sv_sandhausen));
                teamCrest.put(ApplicationConstants.VFL_BOCHUM, String.valueOf(R.drawable.vfl_bochum));
                teamCrest.put(ApplicationConstants.FC_KAISERSLAUTERN, String.valueOf(R.drawable.fc_kaiserslautern));
                teamCrest.put(ApplicationConstants.KARLSRUHER_SC, String.valueOf(R.drawable.karlsruher_sc));
                teamCrest.put(ApplicationConstants.GREUTHER_FURTH, String.valueOf(R.drawable.spvgg_greuther));
                teamCrest.put(ApplicationConstants.FC_HEIDENHEIM, String.valueOf(R.drawable.fc_heidenheim));
                teamCrest.put(ApplicationConstants.ARMINIA_BIELEFELD, String.valueOf(R.drawable.arminia_bielefeld));
                teamCrest.put(ApplicationConstants.FC_UNION_BERLIN, String.valueOf(R.drawable.fc_union));
                teamCrest.put(ApplicationConstants.FSV_FRANKFURT, String.valueOf(R.drawable.fsv_frankfurt));
                teamCrest.put(ApplicationConstants.FORTUNA_DUSSELDORF, String.valueOf(R.drawable.fortuna));
                teamCrest.put(ApplicationConstants.SC_PADERBORN, String.valueOf(R.drawable.sc_paderborn));
                teamCrest.put(ApplicationConstants.TSV_MUNCHEN, String.valueOf(R.drawable.tsv_1860_munich));
                teamCrest.put(ApplicationConstants.MSV_DUISBURG, String.valueOf(R.drawable.msv_duisburg));
                break;

            case ApplicationConstants.BUNDESLIGA_3_PREFERENCES:

                //Bundesliga 3
                teamCrest.put(ApplicationConstants.DYNAMO_DRESDEN, String.valueOf(R.drawable.dynamo_dresden));
                teamCrest.put(ApplicationConstants.SG_SONNENHOF_GROBASPACH, String.valueOf(R.drawable.sg_sonnenhof_grossaspach));
                teamCrest.put(ApplicationConstants.ERZGEBIRGE_AUE, String.valueOf(R.drawable.erzgebirge_aue));
                teamCrest.put(ApplicationConstants.VFL_OSNABRUCK, String.valueOf(R.drawable.vfl_osnabruck));
                teamCrest.put(ApplicationConstants.MAGDEBURG, String.valueOf(R.drawable.magdeburg));
                teamCrest.put(ApplicationConstants.PREUBEN_MUNSTER, String.valueOf(R.drawable.sc_preussen_muenster));
                teamCrest.put(ApplicationConstants.HALLESCHER_FC, String.valueOf(R.drawable.hallescher_fc));
                teamCrest.put(ApplicationConstants.MAINZ, String.valueOf(R.drawable.mainz));
                teamCrest.put(ApplicationConstants.FORTUNA_KOLN, String.valueOf(R.drawable.sc_fortuna_koln));
                teamCrest.put(ApplicationConstants.CHEMNITZER_FC, String.valueOf(R.drawable.chemnitz));
                teamCrest.put(ApplicationConstants.WURZBURGER_KICKERS, String.valueOf(R.drawable.wurzburger_kickers));
                teamCrest.put(ApplicationConstants.SV_WEHEN_WIESBADEN, String.valueOf(R.drawable.wehen_wiesbaden));
                teamCrest.put(ApplicationConstants.VFR_AALEN, String.valueOf(R.drawable.vfr_aalen_wappen));
                teamCrest.put(ApplicationConstants.ENERGIE_COTTBUS, String.valueOf(R.drawable.energie));
                teamCrest.put(ApplicationConstants.HOLSTEIN_KIEL, String.valueOf(R.drawable.holstein_kiel));
                teamCrest.put(ApplicationConstants.FC_HANSA_ROSTOCK, String.valueOf(R.drawable.hansa_rostock));
                teamCrest.put(ApplicationConstants.ROT_WEIB_ERFURT, String.valueOf(R.drawable.rot_weib_erfurt));
                teamCrest.put(ApplicationConstants.VFB_STUTTGART_II, String.valueOf(R.drawable.vfb_stuttgart));
                teamCrest.put(ApplicationConstants.WERDER_BREMEN_II, String.valueOf(R.drawable.werder_bremen));
                teamCrest.put(ApplicationConstants.STUTTGARTER_KICKER, String.valueOf(R.drawable.stuttgarter));
                break;

            case ApplicationConstants.LIGUE_1_PREFERENCES:

                //Ligue 1
                teamCrest.put(ApplicationConstants.PSG, String.valueOf(R.drawable.psg));
                teamCrest.put(ApplicationConstants.MONACO, String.valueOf(R.drawable.as_monaco));
                teamCrest.put(ApplicationConstants.ANGERS, String.valueOf(R.drawable.angers));
                teamCrest.put(ApplicationConstants.CAEN, String.valueOf(R.drawable.caen));
                teamCrest.put(ApplicationConstants.OGC_NICE, String.valueOf(R.drawable.nice));
                teamCrest.put(ApplicationConstants.AS_SAINT_ETIENNE, String.valueOf(R.drawable.saint_etienne));
                teamCrest.put(ApplicationConstants.STADE_RENNAIS, String.valueOf(R.drawable.stade_rennais));
                teamCrest.put(ApplicationConstants.FC_LORIENT, String.valueOf(R.drawable.fc_lorient));
                teamCrest.put(ApplicationConstants.OLYMPIQUE_LYONNAIS, String.valueOf(R.drawable.lyon));
                teamCrest.put(ApplicationConstants.OLYMPIQUE_DE_MARSEILLE, String.valueOf(R.drawable.marseille));
                teamCrest.put(ApplicationConstants.OSC_LILLE, String.valueOf(R.drawable.osc_lille));
                teamCrest.put(ApplicationConstants.GAZELEC_AJACCIO, String.valueOf(R.drawable.gazelec_ajaccio));
                teamCrest.put(ApplicationConstants.FC_NANTES, String.valueOf(R.drawable.fc_nantes));
                teamCrest.put(ApplicationConstants.FC_GIRONDINS_DE_BORDEAUX, String.valueOf(R.drawable.bordeaux));
                teamCrest.put(ApplicationConstants.MONTPELLIER_HERAULT, String.valueOf(R.drawable.montpellier));
                teamCrest.put(ApplicationConstants.SC_BASTIA, String.valueOf(R.drawable.sc_bastia));
                teamCrest.put(ApplicationConstants.STADE_DE_REIMS, String.valueOf(R.drawable.stade_reims));
                teamCrest.put(ApplicationConstants.EA_GUINGAMP, String.valueOf(R.drawable.ea));
                teamCrest.put(ApplicationConstants.TOULOUSE, String.valueOf(R.drawable.toulouse));
                teamCrest.put(ApplicationConstants.ES_TROYES, String.valueOf(R.drawable.es_troyes_ac));
                break;

            case ApplicationConstants.LIGUE_2_PREFERENCES:

                //Ligue 2
                teamCrest.put(ApplicationConstants.AS_NANCY, String.valueOf(R.drawable.as_nancy));
                teamCrest.put(ApplicationConstants.DIJON_FCO, String.valueOf(R.drawable.dijon));
                teamCrest.put(ApplicationConstants.CLERMONT_FOOT, String.valueOf(R.drawable.clermontfoot));
                teamCrest.put(ApplicationConstants.LE_HAVRE, String.valueOf(R.drawable.le_havre));
                teamCrest.put(ApplicationConstants.RED_STAR, String.valueOf(R.drawable.red_star));
                teamCrest.put(ApplicationConstants.FC_METZ, String.valueOf(R.drawable.metz));
                teamCrest.put(ApplicationConstants.RC_LENS, String.valueOf(R.drawable.lens));
                teamCrest.put(ApplicationConstants.AJ_AUXERRE, String.valueOf(R.drawable.aj_auxerroise));
                teamCrest.put(ApplicationConstants.STADE_BRESTOIS, String.valueOf(R.drawable.strade_brestois));
                teamCrest.put(ApplicationConstants.FC_BOURG_EN, String.valueOf(R.drawable.fc_bourg));
                teamCrest.put(ApplicationConstants.FC_STADE_LAVALLOIS, String.valueOf(R.drawable.stade_lavallois));
                teamCrest.put(ApplicationConstants.RC_TOURS, String.valueOf(R.drawable.rc_tours));
                teamCrest.put(ApplicationConstants.EVIAN_THONON_GAILLARD, String.valueOf(R.drawable.evian_thonon));
                teamCrest.put(ApplicationConstants.CHAMOIS_NIORTAIS, String.valueOf(R.drawable.chamois_niortais));
                teamCrest.put(ApplicationConstants.US_CRETEIL, String.valueOf(R.drawable.us_creteil));
                teamCrest.put(ApplicationConstants.SOCHAUX, String.valueOf(R.drawable.sochaux));
                teamCrest.put(ApplicationConstants.VALENCIENNES, String.valueOf(R.drawable.valenciennes));
                teamCrest.put(ApplicationConstants.AJACCIO, String.valueOf(R.drawable.ac_ajaccien));
                teamCrest.put(ApplicationConstants.NIMES_OLYMPIQUE, String.valueOf(R.drawable.nimes_olympique));
                teamCrest.put(ApplicationConstants.PARIS_FC, String.valueOf(R.drawable.paris_fc));
                break;

            case ApplicationConstants.PREMIER_LEAGUE_PREFERENCES:

                //Premier League
                teamCrest.put(ApplicationConstants.ARSENAL, String.valueOf(R.drawable.arsenal));
                teamCrest.put(ApplicationConstants.CHELSEA, String.valueOf(R.drawable.chelsea));
                teamCrest.put(ApplicationConstants.MANCHESTER_UNITED, String.valueOf(R.drawable.manchester_united));
                teamCrest.put(ApplicationConstants.MANCHESTER_CITY, String.valueOf(R.drawable.manchester_city));
                teamCrest.put(ApplicationConstants.SUNDERLAND, String.valueOf(R.drawable.sunderland));
                teamCrest.put(ApplicationConstants.SWANSEA_CITY, String.valueOf(R.drawable.swansea_city));
                teamCrest.put(ApplicationConstants.LIVERPOOL, String.valueOf(R.drawable.liverpool));
                teamCrest.put(ApplicationConstants.NEWCASTLE, String.valueOf(R.drawable.newcastle));
                teamCrest.put(ApplicationConstants.ASTON_VILLA, String.valueOf(R.drawable.aston_villa));
                teamCrest.put(ApplicationConstants.NORWICH_CITY, String.valueOf(R.drawable.norwich_city));
                teamCrest.put(ApplicationConstants.SOUTHAMPTON, String.valueOf(R.drawable.southampton));
                teamCrest.put(ApplicationConstants.STOCK_CITY, String.valueOf(R.drawable.stoke_city));
                teamCrest.put(ApplicationConstants.LEICESTER_CITY, String.valueOf(R.drawable.leicester_city));
                teamCrest.put(ApplicationConstants.TOTTENHAM, String.valueOf(R.drawable.tottenham_hotspur));
                teamCrest.put(ApplicationConstants.CRYSTAL_PALACE, String.valueOf(R.drawable.crystal_palace));
                teamCrest.put(ApplicationConstants.WATFORD, String.valueOf(R.drawable.watford));
                teamCrest.put(ApplicationConstants.WEST_HAM_UNITED, String.valueOf(R.drawable.west_ham));
                teamCrest.put(ApplicationConstants.EVERTON, String.valueOf(R.drawable.everton));
                teamCrest.put(ApplicationConstants.WEST_BROMWICH, String.valueOf(R.drawable.west_bromwich_albion));
                teamCrest.put(ApplicationConstants.AFC_BOURNEMOUTH, String.valueOf(R.drawable.afc_bournemouth));
                break;

            case ApplicationConstants.PRIMERA_DIVISION_PREFERENCES:

                //La Liga
                teamCrest.put(ApplicationConstants.BARCELONA, String.valueOf(R.drawable.barcelona));
                teamCrest.put(ApplicationConstants.ATLETICO_MADRID, String.valueOf(R.drawable.atletico_madrid));
                teamCrest.put(ApplicationConstants.REAL_MADRID, String.valueOf(R.drawable.real_madrid));
                teamCrest.put(ApplicationConstants.CELTA_DE_VIGO, String.valueOf(R.drawable.celta_vigo));
                teamCrest.put(ApplicationConstants.VILLAREAL, String.valueOf(R.drawable.villarreal));
                teamCrest.put(ApplicationConstants.DEPORTIVO, String.valueOf(R.drawable.deportivo_la_coruna));
                teamCrest.put(ApplicationConstants.ATHLETIC_CLUB, String.valueOf(R.drawable.athletic_bilbao));
                teamCrest.put(ApplicationConstants.SEVILLA, String.valueOf(R.drawable.sevilla));
                teamCrest.put(ApplicationConstants.VALENCIA, String.valueOf(R.drawable.valencia));
                teamCrest.put(ApplicationConstants.EIBAR, String.valueOf(R.drawable.eibar_sd));
                teamCrest.put(ApplicationConstants.REAL_BETIS, String.valueOf(R.drawable.real_betis));
                teamCrest.put(ApplicationConstants.ESPANYOL, String.valueOf(R.drawable.espanyol));
                teamCrest.put(ApplicationConstants.MALAGA, String.valueOf(R.drawable.malaga));
                teamCrest.put(ApplicationConstants.REAL_SOCIEDAD, String.valueOf(R.drawable.real_sociedad));
                teamCrest.put(ApplicationConstants.GETAFE, String.valueOf(R.drawable.getafe));
                teamCrest.put(ApplicationConstants.SPORTING_GIJON, String.valueOf(R.drawable.sporting_gijon));
                teamCrest.put(ApplicationConstants.GRANADA, String.valueOf(R.drawable.granada));
                teamCrest.put(ApplicationConstants.RAYO_VALLECANO, String.valueOf(R.drawable.rayo_vallecano));
                teamCrest.put(ApplicationConstants.UD_LAS_PALMAS, String.valueOf(R.drawable.ud_las_palmas));
                teamCrest.put(ApplicationConstants.LEVANTE, String.valueOf(R.drawable.levante));
                break;

            case ApplicationConstants.PRIMEIRA_LIGA_PREFERENCES:

                //Primeira Liga
                teamCrest.put(ApplicationConstants.FC_PORTO, String.valueOf(R.drawable.porto));
                teamCrest.put(ApplicationConstants.SPORTING_LISBON, String.valueOf(R.drawable.sporting_lisbon));
                teamCrest.put(ApplicationConstants.BENFICA_LISSABON, String.valueOf(R.drawable.benfica_sl));
                teamCrest.put(ApplicationConstants.SPORTING_BRAGA, String.valueOf(R.drawable.braga));
                teamCrest.put(ApplicationConstants.VITORIA_SETUBAL, String.valueOf(R.drawable.vitoria_setubal));
                teamCrest.put(ApplicationConstants.FC_PACOS, String.valueOf(R.drawable.pacos));
                teamCrest.put(ApplicationConstants.FC_RIO, String.valueOf(R.drawable.rio_ave));
                teamCrest.put(ApplicationConstants.FC_AROUCA, String.valueOf(R.drawable.arouca_fc));
                teamCrest.put(ApplicationConstants.VITORIA_GUIMARAES, String.valueOf(R.drawable.vitoria_guimaraes));
                teamCrest.put(ApplicationConstants.MARITIMO_FUNCHA, String.valueOf(R.drawable.maritimo_funchal));
                teamCrest.put(ApplicationConstants.GD_ESTORIL, String.valueOf(R.drawable.estoril_praia));
                teamCrest.put(ApplicationConstants.BELENENSES_LISSABON, String.valueOf(R.drawable.belenenses));
                teamCrest.put(ApplicationConstants.NACIONAL_FUNCHAL, String.valueOf(R.drawable.nacional_funchal));
                teamCrest.put(ApplicationConstants.MOREIRENSE_FC, String.valueOf(R.drawable.moreirense_futebol));
                teamCrest.put(ApplicationConstants.UNIAO_MADEIRA, String.valueOf(R.drawable.madeira));
                teamCrest.put(ApplicationConstants.BOAVISTA_PORTO, String.valueOf(R.drawable.boavista));
                teamCrest.put(ApplicationConstants.ACADEMICA_DE_COIMBRA, String.valueOf(R.drawable.academica_de_coimbra));
                teamCrest.put(ApplicationConstants.CD_TONDELA, String.valueOf(R.drawable.cd_tondela));
                break;

            case ApplicationConstants.EREDIVISIE_PREFERENCES:

                //Eredivisie
                teamCrest.put(ApplicationConstants.AJAX_AMSTERDAM, String.valueOf(R.drawable.ajax_amsterdam));
                teamCrest.put(ApplicationConstants.PSV_EINDHOVEN, String.valueOf(R.drawable.psv_eindhoven));
                teamCrest.put(ApplicationConstants.FEYENOORD_ROTTERDAM, String.valueOf(R.drawable.feyenoord_rotterdam));
                teamCrest.put(ApplicationConstants.HERACLES_ALMELO, String.valueOf(R.drawable.heracles_almelo));
                teamCrest.put(ApplicationConstants.VITESSE_ARNHEM, String.valueOf(R.drawable.vitesse_arnhem));
                teamCrest.put(ApplicationConstants.NEC_NIJMEGEN, String.valueOf(R.drawable.nec_nijmegen));
                teamCrest.put(ApplicationConstants.FC_UTRECHT, String.valueOf(R.drawable.fc_utrecht));
                teamCrest.put(ApplicationConstants.FC_GRONINGEN, String.valueOf(R.drawable.fc_groningen));
                teamCrest.put(ApplicationConstants.PEC_ZWOLLE, String.valueOf(R.drawable.pec_zwolle));
                teamCrest.put(ApplicationConstants.ADO_DEN_HAAG, String.valueOf(R.drawable.ado_den_haag));
                teamCrest.put(ApplicationConstants.SC_HEERENVEEN, String.valueOf(R.drawable.sc_heerenveen));
                teamCrest.put(ApplicationConstants.AZ_ALKMAAR, String.valueOf(R.drawable.az_alkmaar));
                teamCrest.put(ApplicationConstants.WILLEM_II, String.valueOf(R.drawable.willem_ii));
                teamCrest.put(ApplicationConstants.EXCELSIOR, String.valueOf(R.drawable.excelsior));
                teamCrest.put(ApplicationConstants.RODA_JC_KERKRADE, String.valueOf(R.drawable.roda_jc_kerkrade));
                teamCrest.put(ApplicationConstants.SC_CAMBUUR_LEEUWARDEN, String.valueOf(R.drawable.sc_cambuur_leeuwarden));
                teamCrest.put(ApplicationConstants.FC_TWENTE_ENSCHEDE, String.valueOf(R.drawable.fc_twente_enschede));
                teamCrest.put(ApplicationConstants.DE_GRAAFSCHAP, String.valueOf(R.drawable.de_graafschap));
                break;

            case ApplicationConstants.SEGUNDA_DIVISION_PREFERENCES:

                //Segunda Division
                teamCrest.put(ApplicationConstants.DEPORTIVO_ALVES, String.valueOf(R.drawable.deportivo_alaves));
                teamCrest.put(ApplicationConstants.CORDOBA, String.valueOf(R.drawable.cordoba));
                teamCrest.put(ApplicationConstants.CA_OSASUNA, String.valueOf(R.drawable.ca_osasuna));
                teamCrest.put(ApplicationConstants.GIMNASTIC, String.valueOf(R.drawable.gimnastic_tarragona));
                teamCrest.put(ApplicationConstants.AD_ALCORCON, String.valueOf(R.drawable.alcorcon));
                teamCrest.put(ApplicationConstants.REAL_OVIEDO, String.valueOf(R.drawable.real_oviedo));
                teamCrest.put(ApplicationConstants.CD_LEGANES, String.valueOf(R.drawable.cd_leganes));
                teamCrest.put(ApplicationConstants.REAL_ZARAGOZA, String.valueOf(R.drawable.real_zaragoza));
                teamCrest.put(ApplicationConstants.CD_LUGO, String.valueOf(R.drawable.lugo));
                teamCrest.put(ApplicationConstants.ELCHE, String.valueOf(R.drawable.elche_cf));
                teamCrest.put(ApplicationConstants.CD_MIRANDES, String.valueOf(R.drawable.cd_mirandes));
                teamCrest.put(ApplicationConstants.SD_PONFERRADINA, String.valueOf(R.drawable.sd_ponferradina));
                teamCrest.put(ApplicationConstants.REAL_VILLADOLID, String.valueOf(R.drawable.real_valladolid));
                teamCrest.put(ApplicationConstants.CD_TENERIFE, String.valueOf(R.drawable.cd_tenerife));
                teamCrest.put(ApplicationConstants.CD_NUMANCIA, String.valueOf(R.drawable.cd_numancia));
                teamCrest.put(ApplicationConstants.HUESCA, String.valueOf(R.drawable.huesca));
                teamCrest.put(ApplicationConstants.UE_LLAGOSTERA, String.valueOf(R.drawable.ue_llagostera));
                teamCrest.put(ApplicationConstants.GIRONA, String.valueOf(R.drawable.girona));
                teamCrest.put(ApplicationConstants.RCD_MALLORCA, String.valueOf(R.drawable.rcd_mallorca));
                teamCrest.put(ApplicationConstants.ALBACETE, String.valueOf(R.drawable.albacete));
                teamCrest.put(ApplicationConstants.ATHLETIC_BILBAO, String.valueOf(R.drawable.athletic_bilbao));
                teamCrest.put(ApplicationConstants.UD_ALMERIA, String.valueOf(R.drawable.ud_almeria));
                break;

            case ApplicationConstants.SERIEA_PREFERENCES:

                //Serie A
                teamCrest.put(ApplicationConstants.MILAN, String.valueOf(R.drawable.inter));
                teamCrest.put(ApplicationConstants.FIORENTINA, String.valueOf(R.drawable.fiorentina));
                teamCrest.put(ApplicationConstants.CARPI, String.valueOf(R.drawable.carpi));
                teamCrest.put(ApplicationConstants.NAPOLI, String.valueOf(R.drawable.napoli));
                teamCrest.put(ApplicationConstants.JUVENTUS, String.valueOf(R.drawable.juventus));
                teamCrest.put(ApplicationConstants.AS_ROMA, String.valueOf(R.drawable.roma));
                teamCrest.put(ApplicationConstants.AC_MILAN, String.valueOf(R.drawable.milan));
                teamCrest.put(ApplicationConstants.SASSUOLO, String.valueOf(R.drawable.sassuolo));
                teamCrest.put(ApplicationConstants.EMPOLI, String.valueOf(R.drawable.empoli));
                teamCrest.put(ApplicationConstants.ATALANTA, String.valueOf(R.drawable.atalanta));
                teamCrest.put(ApplicationConstants.LAZIO, String.valueOf(R.drawable.lazio));
                teamCrest.put(ApplicationConstants.CHIEVO_VERONA, String.valueOf(R.drawable.chievo_verona));
                teamCrest.put(ApplicationConstants.TORINO, String.valueOf(R.drawable.torino));
                teamCrest.put(ApplicationConstants.UDINESE_CALCIO, String.valueOf(R.drawable.udinese));
                teamCrest.put(ApplicationConstants.SAMPDORIA, String.valueOf(R.drawable.sampdoria));
                teamCrest.put(ApplicationConstants.BOLOGNA, String.valueOf(R.drawable.bologna));
                teamCrest.put(ApplicationConstants.CITTA_DI_PALERMO, String.valueOf(R.drawable.palermo));
                teamCrest.put(ApplicationConstants.GENOA, String.valueOf(R.drawable.genoa));
                teamCrest.put(ApplicationConstants.FROSINONE_CALCIO, String.valueOf(R.drawable.frosinone));
                teamCrest.put(ApplicationConstants.HELLAS_VERONA, String.valueOf(R.drawable.hellas_verona));
                break;
        }



        return teamCrest;
    }

    public static ArrayList getTeams(Context context, String preferenceName, int length) {
        ArrayList<String> teams = new ArrayList<>();

        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);

        for (int i = 0; i < length; i++) {
            teams.add(i, sharedPreferences.getString(ApplicationConstants.TEAM + String.valueOf(i), null));
        }

        return teams;
    }


    public static String getLeagueTableInfo(Context context, String preferenceName, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);

        return sharedPreferences.getString(key, null);
    }

    public static ArrayList getLeagueTableInfo(Context context, String preferenceName, int length) {
        ArrayList<String> positions = new ArrayList<>();

        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);

        for (int i = 0; i < length; i++) {
            positions.add(i, sharedPreferences.getString(ApplicationConstants.POSITION + String.valueOf(i), null));
        }

        return positions;
    }

    public static String getFixturesLenght(Context context, String preferenceName, String key) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);

        return sharedPreferences.getString(key, null);

    }

    public static ArrayList getHomeTeamNames(Context context, String preferenceName, int length) {
        ArrayList<String> homeTeamNames = new ArrayList<>();

        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);

        for (int i = 0; i < length; i++) {
            homeTeamNames.add(i, sharedPreferences.getString(ApplicationConstants.HOME_TEAM_NAME + String.valueOf(i), null));
        }

        return homeTeamNames;
    }

    public static ArrayList getAwayTeamNames(Context context, String preferenceName, int length) {
        ArrayList<String> awayTeamNames = new ArrayList<>();

        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);

        for (int i = 0; i < length; i++) {
            awayTeamNames.add(i, sharedPreferences.getString(ApplicationConstants.AWAY_TEAM_NAME + String.valueOf(i), null));
        }

        return awayTeamNames;
    }

    public static ArrayList getHomeGoals(Context context, String preferenceName, int length) {
        ArrayList<String> homeGoals = new ArrayList<>();

        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);

        for (int i = 0; i < length; i++) {
            String goals = sharedPreferences.getString(ApplicationConstants.GOALS_HOME_TEAM + String.valueOf(i), null);

            if (!TextUtils.isEmpty(goals))
                homeGoals.add(i, goals);
            else
                break;
        }

        return homeGoals;
    }

    public static ArrayList getAwayGoals(Context context, String preferenceName, int length) {
        ArrayList<String> awayGoals = new ArrayList<>();

        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);

        for (int i = 0; i < length; i++) {
            String goals = sharedPreferences.getString(ApplicationConstants.GOALS_AWAY_TEAM + String.valueOf(i), null);

            if (!TextUtils.isEmpty(goals))
                awayGoals.add(i, goals);
            else
                break;
        }

        return awayGoals;
    }


}
