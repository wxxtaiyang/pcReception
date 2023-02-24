package com.cykj.mapper;

import com.cykj.bean.PcReport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReportMapper {
    /**
     * //根据条件分页获取所有的用户评估报告
     * @param min 起始日期
     * @param max 结束日期
     * @param minscore 最低分
     * @param maxscore 最高分
     * @param index 下标
     * @param size 长度
     * @return list
     */
    List<PcReport> queryReport(@Param("min")String min,
                                  @Param("max")String max,
                                  @Param("minscore")int minscore,
                                  @Param("maxscore")int maxscore,
                                  @Param("index")int index,
                                  @Param("size")int size);
    /**
     * //根据条件分页获取所有的用户评估报告
     * @param min 起始日期
     * @param max 结束日期
     * @param minscore 最低分
     * @param maxscore 最高分
     * @return list
     */
    int queryCountReport(@Param("min")String min,
                                  @Param("max")String max,
                                  @Param("minscore")int minscore,
                                  @Param("maxscore")int maxscore);
}
