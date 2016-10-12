package ru.taxi.socket;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.*;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    EditText editTextAddress, editTextPort;
    Button buttonConnect, buttonUp, buttonNewConnect, buttonSampleConnect, buttonBalance, buttonPing, buttonVolley;
    TextView buffer;
    TextView responseTextView;
    ActivityManager am;
    Context cx;
    int r;

String combuffer = "{\"58923\":{\"auto\":{\"auto_id\":\"58923\",\"auto_name\":null,\"auto_cdi\":\"7703922943\",\"bills\":{\"282136\":{\"gis_id\":\"282136\",\"bill_id\":\"18810177160821107113\",\"pay_bill_date\":\"2016-08-21\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"50\",\"gis_discount_uptodate\":\"2016-09-12\",\"pay_bill_amount_with_discount\":\"250.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2016-08-21\",\"mos_time\":\"05:04\",\"mos_location\":\"МОСКВА Г.   МИРА ПРОСП. д.125\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"280878\":{\"gis_id\":\"280878\",\"bill_id\":\"18810177160818488098\",\"pay_bill_date\":\"2016-08-18\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"50\",\"gis_discount_uptodate\":\"2016-09-07\",\"pay_bill_amount_with_discount\":\"250.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2016-08-14\",\"mos_time\":\"06:17\",\"mos_location\":\"МОСКВА Г.   ТТК, ВНЕШНЕЕ КОЛЬЦО, СЪЕЗД НА ВАРШАВСКОЕ Ш.\",\"mos_article\":\"12.16.1 - Несоблюдение требований знаков или разметки, за искл.случаев, предусм.др.статьями гл.12\",\"mos_article_number\":\"12.16.1\"},\"280156\":{\"gis_id\":\"280156\",\"bill_id\":\"18810177160817580160\",\"pay_bill_date\":\"2016-08-17\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"50\",\"gis_discount_uptodate\":\"2016-09-06\",\"pay_bill_amount_with_discount\":\"250.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2016-08-17\",\"mos_time\":\"14:12\",\"mos_location\":\"МОСКВА Г.   НАРОДНОГО ОПОЛЧЕНИЯ\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"280157\":{\"gis_id\":\"280157\",\"bill_id\":\"18810177160817443465\",\"pay_bill_date\":\"2016-08-17\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"50\",\"gis_discount_uptodate\":\"2016-09-06\",\"pay_bill_amount_with_discount\":\"250.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2016-08-17\",\"mos_time\":\"06:13\",\"mos_location\":\"МОСКВА Г.   РУСАКОВСКАЯ НАБ.\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"280158\":{\"gis_id\":\"280158\",\"bill_id\":\"18810177160817443007\",\"pay_bill_date\":\"2016-08-17\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"50\",\"gis_discount_uptodate\":\"2016-09-06\",\"pay_bill_amount_with_discount\":\"250.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2016-08-17\",\"mos_time\":\"06:11\",\"mos_location\":\"МОСКВА Г.   ПРОЕКТИРУЕМЫЙ ПРОЕЗД N1889 У Д.8 ПО УЛ. БОЛЬШАЯ ОЛЕНЬЯ, К РУСАКОВСКОЙ НАБ.\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"279423\":{\"gis_id\":\"279423\",\"bill_id\":\"18810177160815266574\",\"pay_bill_date\":\"2016-08-15\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"50\",\"gis_discount_uptodate\":\"2016-09-05\",\"pay_bill_amount_with_discount\":\"250.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2016-08-14\",\"mos_time\":\"06:28\",\"mos_location\":\"МОСКВА Г.   КАШИРСКОЕ Ш. д.94 к.2\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"278951\":{\"gis_id\":\"278951\",\"bill_id\":\"18810177160814152125\",\"pay_bill_date\":\"2016-08-14\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"50\",\"gis_discount_uptodate\":\"2016-09-05\",\"pay_bill_amount_with_discount\":\"250.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2016-08-13\",\"mos_time\":\"06:55\",\"mos_location\":\"МОСКВА Г.   ДМИТРОВСКОЕ Ш. д.88\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"276503\":{\"gis_id\":\"276503\",\"bill_id\":\"18810050160000980531\",\"pay_bill_date\":\"2016-07-25\",\"pay_bill_amount\":\"1000.00\",\"gis_podrazdelenie\":\"4 Р 2 П ДПС (южный) ГИБДД ГУ МВД России по Московской области\",\"gis_discount\":0,\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"1000.00\",\"gis_send_to\":\"УФК по МО (УГИБДД ГУ МВД России по Московской области)\",\"gis_inn\":\"7703037039\",\"gis_kpp\":\"770245001\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810600000010102\",\"gis_wireoktmo\":\"46659000\",\"gis_bank\":\"Отделение 1 Москва \",\"gis_bik\":\"044583001\",\"mos_date\":\"2016-07-25\",\"mos_time\":\"14:55\",\"mos_location\":\"МОСКОВСКАЯ ОБЛ.   А\\/Д МОСКВА-ЩЕЛКОВО 20 км.\",\"mos_article\":\"12.06 - Нар. правил пользования ремнями безопасности или мотошлемами\",\"mos_article_number\":\"12.06\"},\"276504\":{\"gis_id\":\"276504\",\"bill_id\":\"18810177160706758875\",\"pay_bill_date\":\"2016-07-06\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":0,\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"500.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2016-07-06\",\"mos_time\":\"08:04\",\"mos_location\":\"МОСКВА Г.   ЛЕНИНСКИЙ ПРОСП. д.49 стр.3\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"276505\":{\"gis_id\":\"276505\",\"bill_id\":\"18810177160703226643\",\"pay_bill_date\":\"2016-07-03\",\"pay_bill_amount\":\"1500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":0,\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"1500.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2016-06-30\",\"mos_time\":\"20:10\",\"mos_location\":\"МОСКВА Г.   МКАД, 58 КМ 950 М, П-ОПОРА, ВНУТРЕННЯЯ СТОРОНА\",\"mos_article\":\"12.15.1 - Наруш.правил расп.т\\/с на пр.части без выезда на ст.встр.движ.,дв.по обоч.,пересечение колонны\",\"mos_article_number\":\"12.15.1\"},\"276506\":{\"gis_id\":\"276506\",\"bill_id\":\"18810177160702013611\",\"pay_bill_date\":\"2016-07-02\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":0,\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"500.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2016-07-01\",\"mos_time\":\"16:11\",\"mos_location\":\"МОСКВА Г.   ПОС. КИЕВСКИЙ, КИЕВСКОЕ Ш., 62КМ 930М, МГО№017, ИЗ ОБЛАСТИ\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"276507\":{\"gis_id\":\"276507\",\"bill_id\":\"18810177160630356950\",\"pay_bill_date\":\"2016-06-30\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":0,\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"500.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2016-06-30\",\"mos_time\":\"06:43\",\"mos_location\":\"МОСКВА Г.   ПОС. РАССУДОВО, КИЕВСКОЕ Ш., 57КМ 90М,  МГО №159, В ОБЛАСТЬ\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"276508\":{\"gis_id\":\"276508\",\"bill_id\":\"18810277166600495278\",\"pay_bill_date\":\"2016-06-04\",\"pay_bill_amount\":\"1000.00\",\"gis_podrazdelenie\":\"ОБ ДПС ГИБДД УВД по ЮЗАО ГУ МВД России по г. Москве \",\"gis_discount\":0,\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"1000.00\",\"gis_send_to\":\"УФК по г.Москве (УВД ГУ МВД России по ЮЗАО г. Москвы л\\/сч № 04731452510)\",\"gis_inn\":\"7727060703\",\"gis_kpp\":\"772701001\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45905000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2016-06-04\",\"mos_time\":\"06:40\",\"mos_location\":\"МОСКВА Г.   ЯСНОГОРСКАЯ д.21\",\"mos_article\":\"12.06 - Нар. правил пользования ремнями безопасности или мотошлемами\",\"mos_article_number\":\"12.06\"},\"276509\":{\"gis_id\":\"276509\",\"bill_id\":\"18810177150801020021\",\"pay_bill_date\":\"2015-08-01\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"500.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-07-31\",\"mos_time\":\"14:44\",\"mos_location\":\"МОСКВА Г.   БОРИСОВСКИЕ ПРУДЫ д.13 к.1\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"276510\":{\"gis_id\":\"276510\",\"bill_id\":\"18810177150714137559\",\"pay_bill_date\":\"2015-07-14\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"500.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-07-14\",\"mos_time\":\"06:33\",\"mos_location\":\"МОСКВА Г.   НОВОДАНИЛОВСКАЯ НАБ.\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"276511\":{\"gis_id\":\"276511\",\"bill_id\":\"18810177150714146086\",\"pay_bill_date\":\"2015-07-14\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"500.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-07-14\",\"mos_time\":\"06:47\",\"mos_location\":\"МОСКВА Г.   ТТК, ВНЕШ. КОЛЬЦО, НАПРОТИВ УЛ. ЛОБАЧИКА, Д. 3В, МГО №0103\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"276512\":{\"gis_id\":\"276512\",\"bill_id\":\"18810177150714049919\",\"pay_bill_date\":\"2015-07-14\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"500.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-07-14\",\"mos_time\":\"05:44\",\"mos_location\":\"МОСКВА Г.   ТТК, ВНЕШН. КОЛЬЦО, МГО №0867, ЛУЖНЕЦКАЯ ЭСТАКАДА\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"276513\":{\"gis_id\":\"276513\",\"bill_id\":\"18810177150713107133\",\"pay_bill_date\":\"2015-07-13\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"500.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-07-12\",\"mos_time\":\"12:15\",\"mos_location\":\"МОСКВА Г.   КИРОВОГРАДСКАЯ д.19 к.1\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"276514\":{\"gis_id\":\"276514\",\"bill_id\":\"18810177150624611262\",\"pay_bill_date\":\"2015-06-24\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"500.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-06-20\",\"mos_time\":\"16:19\",\"mos_location\":\"МОСКВА Г.   НОВОДАНИЛОВСКАЯ НАБ.\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"276515\":{\"gis_id\":\"276515\",\"bill_id\":\"18810177150316163517\",\"pay_bill_date\":\"2015-03-16\",\"pay_bill_amount\":\"3000.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"3000.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-03-16\",\"mos_time\":\"12:21\",\"mos_location\":\"МОСКВА Г.   ДОРОГОМИЛОВСКАЯ Б. д.7\",\"mos_article\":\"12.17 ч.1.2 - Движение или остановка на полосе для маршрутных ТС в Москве или в Санкт-Петербурге\",\"mos_article_number\":\"12.17 ч.1.2\"},\"276516\":{\"gis_id\":\"276516\",\"bill_id\":\"18810177150306126015\",\"pay_bill_date\":\"2015-03-06\",\"pay_bill_amount\":\"3000.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"3000.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-03-06\",\"mos_time\":\"17:22\",\"mos_location\":\"МОСКВА Г.   ВАРШАВСКОЕ Ш. д.114 к.3\",\"mos_article\":\"12.17 ч.1.2 - Движение или остановка на полосе для маршрутных ТС в Москве или в Санкт-Петербурге\",\"mos_article_number\":\"12.17 ч.1.2\"},\"276517\":{\"gis_id\":\"276517\",\"bill_id\":\"78210177150226005482\",\"pay_bill_date\":\"2015-02-26\",\"pay_bill_amount\":\"3000.00\",\"gis_podrazdelenie\":\"Московская административная дорожная инспекция\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"3000.00\",\"gis_send_to\":\"УФК по г.Москве (МАДИ)\",\"gis_inn\":\"7707821043\",\"gis_kpp\":\"770701001\",\"gis_kbk\":\"78211630020018000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45382000000\",\"gis_bank\":\"в отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-02-25\",\"mos_time\":\"22:38\",\"mos_location\":\"МОСКВА Г.   ВОКЗАЛЬНАЯ ПЛОЩАДЬ (АЭРОПОРТ ВНУКОВО) ЭСТАКАДА, 2-Й УРОВЕНЬ ОТ МГО№28 ДО   \",\"mos_article\":\"12.16.5 - Несоблюдение треб.дор.знаков или разметки, запрещ.остановку или стоянку в Москве, Санкт-Петербурге\",\"mos_article_number\":\"12.16.5\"},\"276518\":{\"gis_id\":\"276518\",\"bill_id\":\"18810150150121974342\",\"pay_bill_date\":\"2015-01-21\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по Московской области\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"500.00\",\"gis_send_to\":\"УФК по МО (УГИБДД ГУ МВД России по Московской области)\",\"gis_inn\":\"7703037039\",\"gis_kpp\":\"770245001\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810600000010102\",\"gis_wireoktmo\":\"46730000\",\"gis_bank\":\"Отделение 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-01-20\",\"mos_time\":\"14:56\",\"mos_location\":\"1146 М-4 ДОН, КАШИРСКОЕ Ш., 32 КМ. 235 М., В \",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"276519\":{\"gis_id\":\"276519\",\"bill_id\":\"18810168150119004360\",\"pay_bill_date\":\"2015-01-19\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ГИБДД УМВД России по Тамбовской области\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"500.00\",\"gis_send_to\":\"УФК по Тамбовской области (УМВД России по Тамбовской области, л\\/с 04641407640)\",\"gis_inn\":\"6831004679\",\"gis_kpp\":\"682901001\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810000000010005\",\"gis_wireoktmo\":\"68701000\",\"gis_bank\":\"ОТДЕЛЕНИЕ ТАМБОВ Г.ТАМБОВ\",\"gis_bik\":\"046850001\",\"mos_date\":\"\",\"mos_time\":\"\",\"mos_location\":\"\",\"mos_article\":\"\",\"mos_article_number\":\"\"},\"276520\":{\"gis_id\":\"276520\",\"bill_id\":\"18810168150119004182\",\"pay_bill_date\":\"2015-01-19\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ГИБДД УМВД России по Тамбовской области\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"500.00\",\"gis_send_to\":\"УФК по Тамбовской области (УМВД России по Тамбовской области, л\\/с 04641407640)\",\"gis_inn\":\"6831004679\",\"gis_kpp\":\"682901001\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810000000010005\",\"gis_wireoktmo\":\"68701000\",\"gis_bank\":\"ОТДЕЛЕНИЕ ТАМБОВ Г.ТАМБОВ\",\"gis_bik\":\"046850001\",\"mos_date\":\"\",\"mos_time\":\"\",\"mos_location\":\"\",\"mos_article\":\"\",\"mos_article_number\":\"\"},\"276521\":{\"gis_id\":\"276521\",\"bill_id\":\"18810168150119003658\",\"pay_bill_date\":\"2015-01-19\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ГИБДД УМВД России по Тамбовской области\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"500.00\",\"gis_send_to\":\"УФК по Тамбовской области (УМВД России по Тамбовской области, л\\/с 04641407640)\",\"gis_inn\":\"6831004679\",\"gis_kpp\":\"682901001\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810000000010005\",\"gis_wireoktmo\":\"68701000\",\"gis_bank\":\"ОТДЕЛЕНИЕ ТАМБОВ Г.ТАМБОВ\",\"gis_bik\":\"046850001\",\"mos_date\":\"\",\"mos_time\":\"\",\"mos_location\":\"\",\"mos_article\":\"\",\"mos_article_number\":\"\"}}}},\"58924\":{\"auto\":{\"auto_id\":\"58924\",\"auto_name\":null,\"auto_cdi\":\"7713314708\",\"bills\":{\"276523\":{\"gis_id\":\"276523\",\"bill_id\":\"18810177150619207162\",\"pay_bill_date\":\"2015-06-19\",\"pay_bill_amount\":\"3000.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"3000.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-06-15\",\"mos_time\":\"19:20\",\"mos_location\":\"МОСКВА Г.   БОРОВСКОЕ Ш.\",\"mos_article\":\"12.17 ч.1.2 - Движение или остановка на полосе для маршрутных ТС в Москве или в Санкт-Петербурге\",\"mos_article_number\":\"12.17 ч.1.2\"},\"276524\":{\"gis_id\":\"276524\",\"bill_id\":\"18810177150618005744\",\"pay_bill_date\":\"2015-06-18\",\"pay_bill_amount\":\"3000.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"3000.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-06-15\",\"mos_time\":\"08:18\",\"mos_location\":\"МОСКВА Г.   БОРОВСКОЕ Ш. д.25\",\"mos_article\":\"12.17 ч.1.2 - Движение или остановка на полосе для маршрутных ТС в Москве или в Санкт-Петербурге\",\"mos_article_number\":\"12.17 ч.1.2\"},\"276525\":{\"gis_id\":\"276525\",\"bill_id\":\"78210177150605014412\",\"pay_bill_date\":\"2015-06-05\",\"pay_bill_amount\":\"3000.00\",\"gis_podrazdelenie\":\"Московская административная дорожная инспекция\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"3000.00\",\"gis_send_to\":\"УФК по г.Москве (МАДИ)\",\"gis_inn\":\"7707821043\",\"gis_kpp\":\"770701001\",\"gis_kbk\":\"78211630020018000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45382000000\",\"gis_bank\":\"в отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-06-01\",\"mos_time\":\"19:45\",\"mos_location\":\"МОСКВА Г.   Г. МОСКВА, УЛ. ВОЛОЧАЕВСКАЯ, Д. 5, КОРПУС 1\",\"mos_article\":\"12.16.5 - Несоблюдение треб.дор.знаков или разметки, запрещ.остановку или стоянку в Москве, Санкт-Петербурге\",\"mos_article_number\":\"12.16.5\"},\"276526\":{\"gis_id\":\"276526\",\"bill_id\":\"18810177150601062626\",\"pay_bill_date\":\"2015-06-01\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"500.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-05-31\",\"mos_time\":\"08:58\",\"mos_location\":\"МОСКВА Г.   МИНСКАЯ д.1Б\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"276527\":{\"gis_id\":\"276527\",\"bill_id\":\"18810150150528831137\",\"pay_bill_date\":\"2015-05-28\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по Московской области\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"500.00\",\"gis_send_to\":\"УФК по МО (УГИБДД ГУ МВД России по Московской области)\",\"gis_inn\":\"7703037039\",\"gis_kpp\":\"770245001\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810600000010102\",\"gis_wireoktmo\":\"46730000\",\"gis_bank\":\"Отделение 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-05-24\",\"mos_time\":\"20:15\",\"mos_location\":\"1146 А\\/Д А-103 «ЩЕЛКОВСКОЕ ШОССЕ», 18КМ + 400\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"276528\":{\"gis_id\":\"276528\",\"bill_id\":\"18810150150330866240\",\"pay_bill_date\":\"2015-03-30\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по Московской области\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"500.00\",\"gis_send_to\":\"УФК по МО (УГИБДД ГУ МВД России по Московской области)\",\"gis_inn\":\"7703037039\",\"gis_kpp\":\"770245001\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810600000010102\",\"gis_wireoktmo\":\"46730000\",\"gis_bank\":\"Отделение 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-03-29\",\"mos_time\":\"07:58\",\"mos_location\":\"1146 А\\/Д ДОМОДЕДОВО, 22 КМ., 650 М., Н.П. СОВ\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"276529\":{\"gis_id\":\"276529\",\"bill_id\":\"18810177150317008159\",\"pay_bill_date\":\"2015-03-17\",\"pay_bill_amount\":\"3000.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"3000.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-03-16\",\"mos_time\":\"14:53\",\"mos_location\":\"МОСКВА Г.   КАШИРСКОЕ Ш. д.24 стр.3\",\"mos_article\":\"12.17 ч.1.2 - Движение или остановка на полосе для маршрутных ТС в Москве или в Санкт-Петербурге\",\"mos_article_number\":\"12.17 ч.1.2\"}}}},\"58925\":{\"auto\":{\"auto_id\":\"58925\",\"auto_name\":null,\"auto_cdi\":\"7706519285\",\"bills\":{\"276530\":{\"gis_id\":\"276530\",\"bill_id\":\"18810177150323171562\",\"pay_bill_date\":\"2015-03-23\",\"pay_bill_amount\":\"500.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"500.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2015-03-22\",\"mos_time\":\"11:04\",\"mos_location\":\"МОСКВА Г.   АНДРОПОВА ПРОСП.\",\"mos_article\":\"12.09.2 - Превышение скорости движения ТС от 20 до 40 км\\/ч\",\"mos_article_number\":\"12.09.2\"},\"276531\":{\"gis_id\":\"276531\",\"bill_id\":\"18810177141012169053\",\"pay_bill_date\":\"2014-10-12\",\"pay_bill_amount\":\"2000.00\",\"gis_podrazdelenie\":\"ЦАФАП ОДД ГИБДД ГУ МВД России по г. Москве\",\"gis_discount\":\"0\",\"gis_discount_uptodate\":\"0000-00-00\",\"pay_bill_amount_with_discount\":\"2000.00\",\"gis_send_to\":\"УФК по г.Москве (УГИБДД ГУ МВД России по г. Москве (ЦАФАП), л\\/сч № 04731440640)\",\"gis_inn\":\"7707089101\",\"gis_kpp\":\"770731005\",\"gis_kbk\":\"18811630020016000140\",\"gis_schet\":\"40101810800000010041\",\"gis_wireoktmo\":\"45379000\",\"gis_bank\":\"в Отделении 1 Москва\",\"gis_bik\":\"044583001\",\"mos_date\":\"2014-10-11\",\"mos_time\":\"11:43\",\"mos_location\":\"МОСКВА Г.   ЛЕНИНГРАДСКИЙ ПРОСП. д.27\",\"mos_article\":\"12.9.6 - Повторное превышение скорости на 40-60 км\\/час\",\"mos_article_number\":\"12.9.6\"}}}}}";

    // Instance of the progress action-view
    MenuItem miActionProgressItem;
JSONArray jsa;

    NewLoader ld;
    UpdateApp atualizaApp;

    String jbuffer = "123_100500_3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        SharedPreferences sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        String myur = sPref.getString("url", "+++++++");
        String mypr = sPref.getString("port", "+++++++");

        editTextAddress = (EditText) findViewById(R.id.addressEditText);
        editTextPort = (EditText) findViewById(R.id.portEditText);
        buttonConnect = (Button) findViewById(R.id.connectButton);
        buttonUp = (Button) findViewById(R.id.upButton);
        buttonNewConnect = (Button) findViewById(R.id.connectNewButton);
            // responseTextView = (TextView) findViewById(R.id.responseTextView);
        buttonSampleConnect = (Button) findViewById(R.id.sampleButton);
        buttonBalance = (Button) findViewById(R.id.balanceButton);
        buttonPing = (Button) findViewById(R.id.pingButton);
        buttonVolley = (Button) findViewById(R.id.volleyButton);

     //   parseJSON("\"session_id\": \"a302150ae274c7fe90b7fd1176a85865bdf16e6a\" "); //----------------------------

      //  checkVer();

        //----------------------------------------------

        if (!editTextAddress.getText().equals("")) {
            myur = editTextAddress.getText().toString();
        }
        if (!editTextPort.getText().equals("")) mypr = editTextPort.getText().toString();

        ed.putString("url", editTextAddress.getText().toString());
        ed.putString("port", editTextPort.getText().toString());
        //ed.putString("url", editTextAddress.getText().toString());
        ed.commit();


      //  ld = new NewLoader(this);
//--------------------------------------------------

        buttonConnect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

mechSetCar();
               // Client myClient = new Client(editTextAddress.getText().toString(), Integer.parseInt("4443"), buffer);
                Client myClient = new Client("192.168.0.13", Integer.parseInt("4443"), combuffer);
                myClient.execute();
            }
        });
        buttonUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              //  buffer.setText("");
                int result = 0;
             //   showProgressBar();

                try {

                    HttpUpLoader uploader = new HttpUpLoader("http://cbzt.changeip.org/upload_file.php?t=car", "/mnt/sdcard/Pictures/MyCameraApp/IMG_20160616_105900.jpg", "1191_bodyfront.jpg");
                    result = uploader.execute().get(20000, TimeUnit.MILLISECONDS);
if(result == 0){}

                } catch (Exception e) {
                    String message = (e.getMessage() == null) ? "Ошибка отправки фото" : e.getMessage();
                    //Utils.log(TAG + "onButtonClick: exception " + message);
                    //showToast(message);
                  //  hideProgressBar();

                    return;
                }
            } // onClick
        });

        buttonNewConnect.setOnClickListener(new View.OnClickListener()
        {
            @Override
                    public void onClick(View v) {



                Image img1 = new Image("/mnt/sdcard/Pictures/MyCameraApp/IMG_20160615_153613.jpg", "1191_bodyfront.jpg");
                Image img2 = new Image("/mnt/sdcard/Pictures/MyCameraApp/IMG_20160615_153627.jpg", "1191_bodyrear.jpg");
                Image img3 = new Image("/mnt/sdcard/Pictures/MyCameraApp/IMG_20160615_153635.jpg", "1191_bodyleft.jpg");
                Image img4 = new Image("/mnt/sdcard/Pictures/MyCameraApp/IMG_20160615_120655.jpg", "1191_bodyright.jpg");
                Image img5 = new Image("/mnt/sdcard/Pictures/MyCameraApp/IMG_20160615_134742.jpg", "1191_dashboard.jpg");
                Image img6 = new Image("/mnt/sdcard/Pictures/MyCameraApp/IMG_20160615_152216.jpg", "1191_trunk.jpg");
                Image img7 = new Image("/mnt/sdcard/Pictures/MyCameraApp/IMG_20160615_152406.jpg", "1191_driver.jpg");
                Image img8 = new Image("/mnt/sdcard/Pictures/MyCameraApp/IMG_20160615_152512.jpg", "1191_yandex.jpg");
                Image img9 = new Image("/mnt/sdcard/Pictures/MyCameraApp/IMG_20160615_152616.jpg", "1191_interiorrear.jpg");
                Image img10 = new Image("/mnt/sdcard/Pictures/MyCameraApp/IMG_20160615_152627.jpg", "1191_interiorfront.jpg");

                for(int i =0; i < 3; i++){
                showProgressBar();
                newTask();

                ld.execute(img1, img2, img3, img4, img5, img6, img7, img8, img9, img10);

            } // for
//responseTextView.setText("OK!!!!");
            } // onClick
        });

        buttonSampleConnect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                combuffer = "00000007 mechanic_sample";
                Client myClient = new Client("ip.cbzt.ru", Integer.parseInt("4443"), combuffer);
                myClient.execute();
            }
        });

        buttonBalance.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                combuffer = "00000002 balance_detail:date_begin=`20160221`;date_end=`20160628`";
                Client myClient = new Client("192.168.0.13", Integer.parseInt("4443"), combuffer);
                myClient.execute();
            }
        });

        buttonPing.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

            //   combuffer = "00000002 get_penalty";
            //    combuffer = "00000002 penalty_image:name=`18810177160822185916_penalty.jpg`";
                combuffer = "00000002 get_rent";
                Client myClient = new Client("192.168.0.13", Integer.parseInt("4443"), combuffer);
                myClient.execute();
            }
        });

        buttonVolley.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

               // ping();
        startApp();
            }
        });
    }// end onCreate


    public void ping () {
        combuffer = "00000009 get_scheme:";
        Client myClient = new Client("ip.cbzt.ru", Integer.parseInt("4443"), combuffer);
        myClient.execute();
    }
//---------------------------------------------Launche and Kill App -----------------------------------------
    public void startApp () {

        boolean res;


    //    Intent LaunchApp = getPackageManager().getLaunchIntentForPackage("ru.yandex.taximeter");
    //    startActivity(LaunchApp);

        cx = getApplicationContext();
        am = (ActivityManager) cx.getSystemService(Context.ACTIVITY_SERVICE);

      //  r = findPIDbyPackageName("ru.yandex.taximeter");

res = killPackageProcesses("ru.yandex.taximeter");
        if (res) {Toast.makeText(cx, "Process killed: ru.yandex.taximeter",Toast.LENGTH_LONG).show();
            Intent LaunchApp = getPackageManager().getLaunchIntentForPackage("ru.yandex.taximeter");
                startActivity(LaunchApp);
        }
    }

    public boolean isPackageRunning(String packagename) {
        return findPIDbyPackageName(packagename) != -1;
    }

    public int findPIDbyPackageName(String packagename) {
        int result = -1;



        if (am != null) {
            for (ActivityManager.RunningAppProcessInfo pi : am.getRunningAppProcesses()){
                if (pi.processName.equalsIgnoreCase(packagename)) {
                    result = pi.pid;
                }
                if (result != -1) break;
            }
        } else {
            result = -1;
        }

        return result;
    }

    public boolean killPackageProcesses(String packagename) {
        boolean result = false;



        if (am != null) {
            am.killBackgroundProcesses(packagename);
            result = !isPackageRunning(packagename);
        } else {
            result = false;
        }

        return result;
    }
//---------------------------------------------------------------------------------------------------------------
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // Store instance of the menu item containing progress
        miActionProgressItem = menu.findItem(R.id.miActionProgress);
        // Extract the action-view from the menu item
        ProgressBar v =  (ProgressBar) MenuItemCompat.getActionView(miActionProgressItem);
        // Return to finish
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void showProgressBar() {
        // Show progress item
        miActionProgressItem.setVisible(true);
      //  miActionProgressItem.expandActionView();
    }

    public void hideProgressBar() {
        // Hide progress item
        miActionProgressItem.setVisible(false);
    }

    public void newTask() {ld = new NewLoader(this);}

    public void mechSetCar() {

        String s ="";
       ArrayList<CarFeatures> abc = new ArrayList<CarFeatures>();
        CarFeatures cf = new CarFeatures("b3f05440-9518-11e2-bf0e-e41f13c17925", "есть", "есть");
     //   cf.setId("b3f05440-9518-11e2-bf0e-e41f13c17925");
     //   cf.setLast("есть");
     //   cf.setToday("нет");
        abc.add(cf);

       //cf.clear();
        CarFeatures cf1 = new CarFeatures("", "", "");
        cf1.setId("b3f05441-9518-11e2-bf0e-e41f13c17925");
        cf1.setLast("есть");
        cf1.setToday("нет");
        abc.add(cf1);

        CarFeatures cf2 = new CarFeatures("", "", "");
        cf2.setId("b3f05442-9518-11e2-bf0e-e41f13c17925");
        cf2.setLast("есть");
        cf2.setToday("есть");
        abc.add(cf2);

        JSONObject carFeatures = new JSONObject();
        JSONArray jsa = new JSONArray();

        try {
for (int i = 0; i< abc.size(); i++) {
    JSONObject jGroup = new JSONObject();


    jGroup.put("today", abc.get(i).getToday());
    jGroup.put("last", abc.get(i).getLast());
    jGroup.put("ID", abc.get(i).getId());
    jsa.put(jGroup);
}

            carFeatures.put("statelist", jsa);
             s = jsa.toString();

        }catch (JSONException e) {}





        combuffer = "00000005 mechanic_set_car:nomer=`а048ку77`;mileage=`152540`;sum=`100233.12`;workservice=`ремень ГРМ, заменить масло...`;" +
                "driver=`8-926-333-16-21`;viewingoptions=`Требуется химчистка`;statelist=`" + s +"`";


    }

    /**
     *
     */

public class CarFeatures {
    private String id;
    private String last;
    private String today;

    public CarFeatures (String id, String td, String ls) {
        this.id = id;
        this.today = td;
        this.last = ls;
    }

    public String getId() {return id;}
    public String getLast() {return last;}
    public String getToday() {return today;}

    public void setId (String id) {this.id = id;}
    public void setLast (String last) {this.last = last;}
    public void setToday (String today) {this.today = today;}

    public void clear() {
        id = "";
        last = "";
        today = "";
    }
    }

public void checkVer() {
    String versionName = BuildConfig.VERSION_NAME;
    String bufferver = "00000006 mechanic_ver_check";
    Client myClient = new Client("ip.cbzt.ru", Integer.parseInt("4443"), bufferver);
    myClient.execute();


    atualizaApp = new UpdateApp();
    atualizaApp.setContext(getApplicationContext());
    atualizaApp.execute("http://ip.cbzt.ru/update/taxi_3.12.apk");
}

public void parseJSON (String str) {
    JSONObject dataJsonObj = null;

    try {
        dataJsonObj = new JSONObject(str);
       for(Iterator<String> it = dataJsonObj.keys(); it.hasNext();) {
           String key = it.next();
           Log.d("tag", key);
       }




    }catch (JSONException e) {
        e.printStackTrace();
        Log.d("JSON", "  "+e);
    }
}

}
