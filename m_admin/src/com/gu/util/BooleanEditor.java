/**
 * tzdeskϵͳƽ̨
 * tzupload
 * com.tz.util
 * DateFormateEditor.java
 * ������:xuchengfei 
 * ʱ�䣺2015��11��13��-����8:56:36 
 * 2015̶�ݽ���˾-��Ȩ����
 */
package com.gu.util;

import java.beans.PropertyEditorSupport;

/**
 * 
 * 
 * BooleanEditor
 * 创建人:gulj
 * 时间：2015年12月1日-下午2:29:27 
 * @version 1.0.0
 *
 */
public class BooleanEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(GStringUtils.isNotEmpty(text)){
			if(text.equalsIgnoreCase("3"))setValue(true);
			if(text.equalsIgnoreCase("4"))setValue(false);
		}else{
			setValue(false);
		}
	}
}
