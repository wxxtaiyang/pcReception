package com.cykj.mapper;

import com.cykj.bean.PcReport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReportMapper {
    /**
     * 添加在线评估报告
     * @param report 报告类
     * @return int
     */
    int insertReport(PcReport report);

    /**
     * 根据用户id分页查询所有的报告
     * @param userid 用户id
     * @param index 起始位置
     * @param size 长度
     * @return list
     */
    List<PcReport> queryAllReportByUserId(@Param("userid")long userid,
                                          @Param("index")int index,
                                          @Param("size")int size);

    /**
     * 根据用户id查收用户的在线报告长度
     * @param userid 用户id
     * @return int
     */
    int querySizeReportByUserId(@Param("userid")long userid);
}
