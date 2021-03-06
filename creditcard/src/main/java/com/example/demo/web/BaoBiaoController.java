package com.example.demo.web;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.Bill;
import com.example.demo.pojo.Bystages;
import com.example.demo.service.ReportFormService;
import com.example.demo.vo.BaoBiaoVo;
import com.github.pagehelper.PageInfo;
/**
 * 报表打印 Controller
 * @author Administrator
 *
 */
@Controller
public class BaoBiaoController {
	@Autowired
	private ReportFormService reportFormService;
	/**
	 * 分期表页面跳转
	 * @return
	 */
	@RequestMapping("index")
	public String baobiaoxiang() {
		return "index";
	}
	
	/**
	 * 跳转到打印报表页面
	 * @param model
	 * @return
	 */
	@RequestMapping("reportFormXls")
	public String report(Model model,BaoBiaoVo baoBiaoVo) {
		PageInfo<Bystages> pageInfo = reportFormService.getAll(baoBiaoVo);
		List<Bystages> userList = pageInfo.getList();
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("baoBiaoVo", baoBiaoVo);
		model.addAttribute("userList", userList);
		return "baobiao";
	}
	/**
	 * 报表打印
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("reportForm")
	public void reportForm(HttpServletResponse response,BaoBiaoVo baoBiaoVo) throws Exception {
		System.out.println(baoBiaoVo);
		//返回需要打印的数据
		List<Bystages> userList = reportFormService.getAlls(baoBiaoVo);
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("获取excel测试表格");
		HSSFRow row = null;

		row = sheet.createRow(0);
		row.setHeight((short) (26.25 * 20));
		row.createCell(0).setCellValue("用户分期信息列表");
		row.getCell(0).setCellStyle(getStyle(wb, 0));// 设置样式
		for (int i = 1; i <= 9; i++) {
			row.createCell(i).setCellStyle(getStyle(wb, 0));
		}
		CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 9);
		sheet.addMergedRegion(rowRegion);

		CellRangeAddress columnRegion = new CellRangeAddress(1, userList.size()+1, 0, 0);
		sheet.addMergedRegion(columnRegion);

		row = sheet.createRow(1);
		row.createCell(0).setCellStyle(getStyle(wb, 3));
		row.setHeight((short) (22.50 * 20));
		row.createCell(1).setCellValue("用户");
		row.createCell(2).setCellValue("分期总金额");
		row.createCell(3).setCellValue("分期期数");
		row.createCell(4).setCellValue("单期手续费 ");
		row.createCell(5).setCellValue("每期应还");
		row.createCell(6).setCellValue("已还期数");
		row.createCell(7).setCellValue("提醒次数");
		row.createCell(8).setCellValue("创建时间");
		row.createCell(9).setCellValue("更新时间");
		
		for (int i = 1; i <= 9; i++) {
			row.getCell(i).setCellStyle(getStyle(wb, 1));
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
		for (int i = 0; i < userList.size(); i++) {
			row = sheet.createRow(i + 2);
			Bystages user = userList.get(i);
			row.createCell(1).setCellValue(user.getCredid());
			row.createCell(2).setCellValue(user.getTotalmoney());
			row.createCell(3).setCellValue(user.getTotalmonth());
			row.createCell(4).setCellValue(user.getRate());
			row.createCell(5).setCellValue(user.getMonthsend());
			row.createCell(6).setCellValue(user.getEndsendMonthnum());
			row.createCell(7).setCellValue(user.getRemindnum());
			if (user.getCreatetime() != null) {
				row.createCell(8).setCellValue(sdf.format(user.getCreatetime()));
			}
			if (user.getUpdatetime() != null) {
				row.createCell(9).setCellValue(sdf.format(user.getUpdatetime()));
			}
			for (int j = 1; j <= userList.size(); j++) {
				row.getCell(j).setCellStyle(getStyle(wb, 2));
			}
		}

		// 默认行高
		sheet.setDefaultRowHeight((short) (16.5 * 20));
		// 列宽自适应
		for (int i = 0; i <= 13; i++) {
			sheet.autoSizeColumn(i);
		}

		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		OutputStream os = response.getOutputStream();
		wb.write(os);
		os.flush(); 
		os.close();
	}
	
	/**
	 * 跳转到打印报表页面
	 * @param model
	 * @return
	 */
	@RequestMapping("billXls")
	public String billXls(Model model,BaoBiaoVo baoBiaoVo) throws Exception {
		PageInfo<Bill> pageInfo = reportFormService.getBillAll(baoBiaoVo);
		List<Bill> billList=pageInfo.getList();
		model.addAttribute("billList", billList);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("baoBiaoVo", baoBiaoVo);
		return "liuShuiBiao";
	}
	/**
	 * 报表打印
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("billReportForm")
	public void billReportForm(HttpServletResponse response,BaoBiaoVo baoBiaoVo) throws Exception {
		List<Bill> userList = reportFormService.getBillAlls(baoBiaoVo);
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("获取excel测试表格");
		HSSFRow row = null;

		row = sheet.createRow(0);
		row.setHeight((short) (26.25 * 20));
		row.createCell(0).setCellValue("用户流水信息列表");
		row.getCell(0).setCellStyle(getStyle(wb, 0));// 设置样式
		for (int i = 1; i <= 7; i++) {
			row.createCell(i).setCellStyle(getStyle(wb, 0));
		}
		CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 7);
		sheet.addMergedRegion(rowRegion);

		CellRangeAddress columnRegion = new CellRangeAddress(1, userList.size()+1, 0, 0);
		sheet.addMergedRegion(columnRegion);

		row = sheet.createRow(1);
		row.createCell(0).setCellStyle(getStyle(wb, 3));
		row.setHeight((short) (22.50 * 20));
		row.createCell(1).setCellValue("收款用户");
		row.createCell(2).setCellValue("收款金额");
		row.createCell(3).setCellValue("流水类型");
		row.createCell(4).setCellValue("付款卡类型 ");
		row.createCell(5).setCellValue("付款卡 ");
		row.createCell(6).setCellValue("用户");
		row.createCell(7).setCellValue("创建时间");
		for (int i = 1; i <= 7; i++) {
			row.getCell(i).setCellStyle(getStyle(wb, 1));
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
		for (int i = 0; i < userList.size(); i++) {
			row = sheet.createRow(i + 2);
			Bill user = userList.get(i);
			row.createCell(1).setCellValue(user.getReceivepeople());
			row.createCell(2).setCellValue(user.getReceivemoney());
			row.createCell(3).setCellValue(user.getBilltype());
			row.createCell(4).setCellValue(user.getSendcardtype());
			row.createCell(5).setCellValue(user.getSendcardid());
			row.createCell(6).setCellValue(user.getUserId());
			row.createCell(7).setCellValue(sdf.format(user.getCreatetime()));
			for (int j = 1; j <= 7; j++) {
				row.getCell(j).setCellStyle(getStyle(wb, 2));
			}
		}

		// 默认行高
		sheet.setDefaultRowHeight((short) (16.5 * 20));
		// 列宽自适应
		for (int i = 0; i <= 13; i++) {
			sheet.autoSizeColumn(i);
		}

		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		OutputStream os = response.getOutputStream();
		wb.write(os);
		os.flush();
		os.close();
	}
	
	
	
	

	/**
	 * 获取样式
	 * 
	 * @param hssfWorkbook
	 * @param styleNum
	 * @return
	 */
	public HSSFCellStyle getStyle(HSSFWorkbook hssfWorkbook, Integer styleNum) {
		HSSFCellStyle style = hssfWorkbook.createCellStyle();
		style.setBorderRight(BorderStyle.THIN);// 右边框
		style.setBorderBottom(BorderStyle.THIN);// 下边框

		HSSFFont font = hssfWorkbook.createFont();
		font.setFontName("微软雅黑");// 设置字体为微软雅黑

		HSSFPalette palette = hssfWorkbook.getCustomPalette();// 拿到palette颜色板,可以根据需要设置颜色
		switch (styleNum) {
		case (0): {
			style.setAlignment(HorizontalAlignment.CENTER_SELECTION);// 跨列居中
			font.setBold(true);// 粗体
			font.setFontHeightInPoints((short) 14);// 字体大小
			style.setFont(font);
			palette.setColorAtIndex(HSSFColor.BLUE.index, (byte) 184, (byte) 204, (byte) 228);// 替换颜色板中的颜色
			style.setFillForegroundColor(HSSFColor.BLUE.index);
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}
			break;
		case (1): {
			font.setBold(true);// 粗体
			font.setFontHeightInPoints((short) 11);// 字体大小
			style.setFont(font);
		}
			break;
		case (2): {
			font.setFontHeightInPoints((short) 12);
			style.setFont(font);
		}
			break;
		case (3): {
			style.setFont(font);

			palette.setColorAtIndex(HSSFColor.GREEN.index, (byte) 0, (byte) 32, (byte) 96);// 替换颜色板中的颜色
			style.setFillForegroundColor(HSSFColor.GREEN.index);
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}
			break;
		}

		return style;
	}

}
