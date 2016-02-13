package br.ufc.quixada.es.ScrumTool.entidades;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public class ListEmmiters {
	 List<SseEmitter> list = new ArrayList<SseEmitter>();
	 
	 public void add(SseEmitter e){
		 list.add(e);
	 }
	 public void remove(SseEmitter e){
		 list.remove(e);
	 }
	 
	 public List<SseEmitter> getList(){
		 return list;
	 }
}
