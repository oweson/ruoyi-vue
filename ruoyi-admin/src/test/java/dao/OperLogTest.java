package dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.domain.SysOperLog;
import com.ruoyi.system.mapper.SysNoticePlus;
import com.ruoyi.system.mapper.SysOperLogMapper;
import org.junit.Test;
import service.App;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author oweson
 * @date 2022/10/4 14:35
 */


public class OperLogTest extends App {

    @Resource
    private SysOperLogMapper sysOperLogMapper;

    @Resource

    private SysNoticePlus sysNoticePlus;



    @Test

    public void mybatisTest(){

        List<SysOperLog> sysOperLogs = sysOperLogMapper.selectOperLogList(new SysOperLog());

        System.out.println(sysOperLogs);
    }


    @Test
    public void plusTest(){

       /* List<SysNotice> sysNotices = sysNoticePlus.selectList(new QueryWrapper<>());

        System.out.println(sysNotices);*/

        Page<SysNotice> sysNoticePage = sysNoticePlus.selectPage(new Page<>(1, 10), new QueryWrapper<>());

        sysNoticePage.getRecords().stream().forEach(x->{

            x.setNoticeContent("fuck!!!");
        });

        System.out.println(sysNoticePage);

        System.out.println(sysNoticePage);


    }
}
