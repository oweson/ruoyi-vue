package dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

        List<SysNotice> sysNotices = sysNoticePlus.selectList(new QueryWrapper<>());

        System.out.println(sysNotices);


    }
}
