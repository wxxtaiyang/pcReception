package com.cykj.mapper;

import com.cykj.bean.PcOnlinetopic;
import com.cykj.bean.PcOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*题库管理（包含题目与选项）*/
public interface OnlineTopicMapper {
    /**
     * 根据id查询题目
     * @param id id
     * @return list
     */
    List<PcOnlinetopic> queryOnlinetopicById(@Param("id") long id,
                                             @Param("limit") int limit,
                                             @Param("size") int size);

    /**
     * 根据id查询题目总长度
     * @param id id
     * @return int
     */
    int countOnlieOnlinetopicById(@Param("id") long id);

    /**
     * 添加在线题目
     * @param onlinetopic 题目类
     * @return int
     */
    int insertOnlietopic(PcOnlinetopic onlinetopic);

    /**
     * 添加在线题目的选项
     * @param list 选项集合
     * @return int
     */
    int insertOnlietopicOptions(@Param("list") List<PcOption> list);

    /**
     * 根据id删除题目
     * @param onlineid 题目id
     * @return int
     */
    int deleteOnlineTopById(@Param("id")long onlineid);

    /**
     * 修改题目
     * @param onlinetopic 题目类
     * @return int
     */
    int updateOnlineTopById(PcOnlinetopic onlinetopic);

    /**
     * 根据题目id删除选项信息
     * @param onlineid 题目id
     * @return int
     */
    int deleteOptionsById(@Param("id")long onlineid);
}
