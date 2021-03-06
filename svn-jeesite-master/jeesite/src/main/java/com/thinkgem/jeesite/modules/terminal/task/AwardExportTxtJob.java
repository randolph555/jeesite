package com.thinkgem.jeesite.modules.terminal.task;

import com.thinkgem.jeesite.modules.sys.utils.DictUtils;
import com.thinkgem.jeesite.modules.terminal.service.ExchangeAwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Lazy(false)
@Component("awardExportTxtJob")
public class AwardExportTxtJob {

    @Autowired
    ExchangeAwardService service;

    @Value("${expiry.txtTitle}")
    String fileName;

    @Scheduled(cron = "0 40 05 ? * *")
    public void export() {
        String baseDir = DictUtils.getDictValue("ticketFile");
        service.generateTxt(fileName,baseDir);
    }
}