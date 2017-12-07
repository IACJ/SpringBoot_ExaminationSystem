package examination.service;

import com.github.abel533.echarts.Grid;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.feature.Feature;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.MarkLine;
import com.github.abel533.echarts.series.MarkPoint;
import examination.dao.ChartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

class Data {

    String type;
    String name;

    public Data(String type, String name) {
        this.type = type;
        this.name = name;
    }
}

@Service
public class ChartService {
    @Autowired
    ChartDao chartDao;
    public String studentGetChart(long studentId) {
        List<String> name = chartDao.getPaperName(studentId) ;
        List<Byte> data = chartDao.getScore(studentId) ;
        List<String> reformatName = new ArrayList<>();

        name.forEach((item -> reformatName.add(String.join("\n", item.split("")))));
        GsonOption option = new GsonOption();
        Grid grid = new Grid();
        grid.setY2("30%");
        option.title("成绩图").tooltip(Trigger.item).grid(grid).toolbox().feature(Feature.saveAsImage);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setBoundaryGap(false);
        categoryAxis.setData(reformatName);
        option.xAxis(categoryAxis);
        option.yAxis(new ValueAxis());

        Line line = new Line();
        line.setData(data);
        line.markPoint(new MarkPoint().data(new Data("max","最高分"),new Data("min","最低分")));
        line.markLine(new MarkLine().data(new Data("average","平均分")));

        option.series(line);
        return option.toPrettyString();
    }
}
