import org.icepear.echarts.Option;
import org.icepear.echarts.charts.bar.BarLabel;
import org.icepear.echarts.charts.bar.BarSeries;
import org.icepear.echarts.components.coord.cartesian.CategoryAxis;
import org.icepear.echarts.components.coord.cartesian.ValueAxis;
import org.icepear.echarts.origin.coord.cartesian.AxisOption;
import org.icepear.echarts.origin.util.SeriesOption;
import org.icepear.echarts.render.Engine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.github.jknack.handlebars.internal.lang3.StringUtils.split;

/**
 * @author 孟繁兴
 */
public class Demo02 {
    public static void main(String[] args) {

        CategoryAxis xAxis = new CategoryAxis()
                .setType("category")
                .setData(new String[]{"11-09", "11-08", "11-07", "11-06", "11-05", "11-04", "11-03", "11-02", "11-01"});

        ValueAxis yAxis1 = new ValueAxis()
                .setType("value")
                .setName("每日用量/度")
                .setMin(0)
                .setMax(6)
                .setInterval(1);

        BarSeries series2 = new BarSeries()
                .setName("电费")
                .setType("line")
                .setLabel(new BarLabel().setShow(true).setPosition("top"))
                .setData(new Number[]{4.69, 3.39, 4.09, 3.61, 3.67, 3.25, 3.76, 3.71, 3.33});

        Option option = new Option()
                .setXAxis(xAxis)
                .setYAxis(new AxisOption[]{yAxis1})
                .setSeries(new SeriesOption[]{series2});

        new Engine().render("index.html", option);
        System.out.println(getDataPart("2022-11-07"));
    }

    public static String getDataPart(String dataStr) {
        String[] content1 = dataStr.split("-");
        return content1[1] + "/" +content1[2];
    }
}
