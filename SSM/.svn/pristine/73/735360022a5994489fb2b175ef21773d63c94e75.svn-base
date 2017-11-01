package com.etoak.modules.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClinetTest {
	
	@Test
	public void doGet() throws Exception{
		//创建一个浏览器
		CloseableHttpClient httpClient =
				HttpClients.createDefault();
		//在浏览器地址栏中输入地址
		//http://localhost:8080/SSM/http/doGetParams?username=etoak&password=et1702
		URIBuilder uri = 
				new URIBuilder("http://localhost:8080/SSM/http/doGetParams");
		uri.addParameter("username", "etoak");
		uri.addParameter("password", "et1702");
		//发送get请求
		HttpGet get = new HttpGet(uri.build());
		
		//回车发送请求到服务端，返回响应数据
		CloseableHttpResponse response =
				httpClient.execute(get);
		//返回响应状态码  200表示成功
		int statusCode = 
				response.getStatusLine().getStatusCode();
		//判断状态码是否为200
		if(statusCode == HttpStatus.SC_OK){
			//返回响应数据（HttpEntity就是一个二进制的流信息）
			HttpEntity entity = response.getEntity();
			//把返回响应数据转换成字符串（把二进制流信息转换成字符串）
			String result = EntityUtils.toString(entity);
			System.out.println("返回结果集：" + result);
		}else{
			System.out.println("失败！！！");
		}
		//关闭响应
		response.close();
		//关闭浏览器
		httpClient.close();
	}
	
	@Test
	public void doGetSouGou() throws Exception{
		//创建一个浏览器
		CloseableHttpClient httpClient =
				HttpClients.createDefault();
		//在浏览器地址栏中输入地址
		URIBuilder uri = 
				new URIBuilder("https://www.sogou.com/web?query=%E6%A5%9A%E4%B9%94%E4%BC%A0&_asf=www.sogou.com&_ast=&w=01019900&p=40040100&ie=utf8&from=index-nologin&s_from=index&sut=6049&sst0=1499224858792&lkt=2%2C1499224852744%2C1499224853062&sugsuv=1499224850263272&sugtime=1499224858792");
		//uri.addParameter("query", "楚乔传");
		//发送get请求
		HttpGet get = new HttpGet(uri.build());
		
		//回车发送请求到服务端，返回响应数据
		CloseableHttpResponse response =
				httpClient.execute(get);
		//返回响应状态码  200表示成功
		int statusCode = 
				response.getStatusLine().getStatusCode();
		//判断状态码是否为200
		if(statusCode == HttpStatus.SC_OK){
			//返回响应数据（HttpEntity就是一个二进制的流信息）
			HttpEntity entity = response.getEntity();
			//把返回响应数据转换成字符串（把二进制流信息转换成字符串）
			String result = EntityUtils.toString(entity);
			System.out.println(result);
		}else{
			System.out.println("失败！！！");
		}
		//关闭响应
		response.close();
		//关闭浏览器
		httpClient.close();
	}
	
	@Test
	public void doPost() throws Exception{
		//创建一个浏览器
		CloseableHttpClient httpClient = 
				HttpClients.createDefault();
		//在地址栏中输入请求地址
		HttpPost post = 
				new HttpPost("http://localhost:8080/SSM/http/doPostParams");
		
		//设置连接超时、网路超时  5秒
		RequestConfig config = RequestConfig.custom()
		.setConnectTimeout(5000)
		.setSocketTimeout(5000).build();
		//设置post请求超时
		post.setConfig(config);
		
		//设置请求参数
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("name", "张三"));
		params.add(new BasicNameValuePair("cardId", "9527"));
		//设置一个表单
		HttpEntity httpEntity = 
				new UrlEncodedFormEntity(params, "UTF-8");
		//把参数实体放入post请求中
		post.setEntity(httpEntity);
		
		//回车发送请求，并返回响应信息
		CloseableHttpResponse response = 
				httpClient.execute(post);
		//返回响应状态码 200表示成功
		int statusCode = 
				response.getStatusLine().getStatusCode();
		//判断状态码是否为200
		if(statusCode == 200){
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity, Consts.UTF_8);
			System.out.println(result);
		}else{
			System.out.println("响应结果失败！！！");
		}
		//关闭资源
		response.close();
		httpClient.close();
	}
	
	@Test
	public void doPostJson() throws Exception{
		CloseableHttpClient httpClient = 
				HttpClients.createDefault();
		
		//HttpDelete
		//HttpPut
		
		HttpPost post = 
				new HttpPost("http://localhost:8080/SSM/http/doPostJson");
		//发送json请求
		post.addHeader("Content-Type", "application/json");
		//定义json数据
		String json = "{\"name\":\"李四\",\"cardId\":\"9527\"}";
		//定义一个字符串实体
		StringEntity strEntity = new StringEntity(json, Consts.UTF_8);
		//将字符串实体加入post请求中
		post.setEntity(strEntity);
		
		CloseableHttpResponse response = 
				httpClient.execute(post);
		int statusCode = 
				response.getStatusLine().getStatusCode();
		if(statusCode == HttpStatus.SC_OK){
			String result = 
					EntityUtils.toString(response.getEntity(), Consts.UTF_8);
			System.out.println(result);
		}
	}

}
