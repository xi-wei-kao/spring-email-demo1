package com.example.email1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.email1.controller.dto.EmailTest1ReqResDTO;
import com.example.email1.service.EmailTest1Service;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailTest1Service emailTest1Service;
	
	@PostMapping(path = "/test1")
	public String getEmailTest1(@RequestBody EmailTest1ReqResDTO reqBody) {
		
		return emailTest1Service.process(reqBody);
	}


	public void checkNonExecuteCollection() {

		// [STEP]: 查詢所有Collection爬蟲

		// [STEP]: 依序換算爬蟲 cron-expression, 取得最後預計執行時間(cron-utils)
		// PS: 換算結果暫存, 若下次執行無變動cron則直接從記憶體抓取

		// [STEP]: 每筆「最後預計執行時間」, 過濾出檢查週期間「須執行爬蟲清單」

		// [STEP]: 以「須執行爬蟲清單」查詢JOB_HIST表【時間區間 + RUN_RESULT不等於SUCCESS查詢】,
		//         取得「實際執行爬蟲錯誤清單」

		// [STEP]: 拜訪「實際執行爬蟲錯誤清單」, 依序執行「有執行但有錯誤類型告警(email-sender)」

		// [STEP]: 比較「須執行爬蟲清單」及「實際執行爬蟲錯誤清單」, 將無執行的爬蟲類別篩選出「無執行爬蟲清單」

		// [STEP]: 拜訪「無執行爬蟲清單」, 依序執行「無執行爬蟲類型告警(email-sender)」

	}

	public void checkNonExecuteProcess() {

		// [STEP]: 查詢所有Process爬蟲

		// [STEP]: 依序換算爬蟲 cron-expression, 取得最後預計執行時間(cron-utils)
		// PS: 換算結果暫存, 若下次執行無變動cron則直接從記憶體抓取

		// [STEP]: 每筆「最後預計執行時間」, 過濾出檢查週期間「須執行爬蟲清單」

		// [STEP]: 以「須執行爬蟲清單」查詢JOB_HIST表【時間區間 + RUN_RESULT不等於SUCCESS查詢】,
		//         取得「實際執行爬蟲錯誤清單」

		// [STEP]: 拜訪「實際執行爬蟲錯誤清單」, 依序執行「有執行但有錯誤類型告警(email-sender)」

		// [STEP]: 比較「須執行爬蟲清單」及「實際執行爬蟲錯誤清單」, 將無執行的爬蟲類別篩選出「無執行爬蟲清單」

		// [STEP]: 拜訪「無執行爬蟲清單」, 依序執行「無執行爬蟲類型告警(email-sender)」

	}

}
