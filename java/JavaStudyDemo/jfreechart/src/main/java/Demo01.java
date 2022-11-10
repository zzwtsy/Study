import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import static org.jfree.chart.ChartUtils.saveChartAsPNG;

/**
 * @author 孟繁兴
 */
public class Demo01 {
    public static void main(String[] args) {
        try {
            //设置主题
            StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
            standardChartTheme.setExtraLargeFont(new Font("HarmonyOS_Sans_SC", Font.BOLD, 20));
            standardChartTheme.setRegularFont(new Font("HarmonyOS_Sans_SC", Font.BOLD, 16));
            standardChartTheme.setLargeFont(new Font("HarmonyOS_Sans_SC", Font.BOLD, 16));
            ChartFactory.setChartTheme(standardChartTheme);
            //构造数据
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.addValue(100, "JAVA", "1");
            dataset.addValue(200, "js", "1");
            dataset.addValue(200, "C++", "2");
            dataset.addValue(300, "C", "3");
            dataset.addValue(400, "HTML", "4");
            dataset.addValue(400, "CSS", "5");
            String[] category = {"1", "2", "3", "4", "5"};
            Double[] values = {3.1, 2.0, 4.3, 4.4, 3.3};
            DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();

            /*
             * public static JFreeChart createBarChart3D(
             * java.lang.String title, 设置图表的标题
             * java.lang.String categoryAxisLabel, 设置分类轴的标示
             * java.lang.String valueAxisLabel, 设置值轴的标示
             * CategoryDataset dataset, 设置数据
             * PlotOrientation orientation, 设置图表的方向
             * boolean legend, 设置是否显示图例
             * boolean tooltips,设置是否生成热点工具
             * boolean urls) 设置是否显示url
             */
            JFreeChart chart = ChartFactory.createLineChart("电量使用情况", "时间/日", "电量/度", dataset, PlotOrientation.VERTICAL, true, false, false);
            chart.setTextAntiAlias(true);
            //保存图表
            saveChartAsPNG(new File("BarChart3D.png"), chart, 800, 500);
            System.out.println("绘图完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
