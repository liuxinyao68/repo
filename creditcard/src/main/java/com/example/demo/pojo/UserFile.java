package com.example.demo.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * 用户办卡上传审核文件
 * @author Administrator
 *
 */
public class UserFile {

  private String id;
  /** 文件状态，是否审核 */
  private String state;
  /** 审核意见 */
  private String remark;
  /** 用户id */
  private String applierId;
  /** 申请时间 */
  private Date applytime;
  /** 审核人id */
  private String auditorId;
  /** 审核时间 */
  private Date audittime;
  /** 审核分数 */
  private String authscore;
  /** 文件路径 */
  private String fileroute;
  /** 文件类型 */
  private String filetypeId;
  private Date createtime;
  private Date updatetime;
  private String ifDelete;


}
