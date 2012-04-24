package com.qrms.action.puzzlesolvinggame;

import java.util.ArrayList;
import junit.framework.TestCase;
import org.easymock.MockControl;
import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.service.ISeekGameService;
/**

 * @author Zhao Lu & ZhangZu
 * @version 3.0
 * 
 * @modify 1 Zhao Lu & ZhangZu 
 * 
 * @modify 2 YinShunMing & ZhaoLu 
 */
public class SeekGameActionTest extends TestCase {

	SeekGameAction ga;
	MockControl control;
	ISeekGameService mock;

	public void setUp() {
		ga = new SeekGameAction();
		ga.setCity("NanJing");
		ga.setProv("JiangSu");
		ga.setCou("China");
		ga.setOrigin_lat(0);
		ga.setOrigin_long(0);
		ga.setLat_h(0);
		ga.setLat_mmss(0);
		ga.setLat_ns(1);
		ga.setLong_ew(1);
		ga.setLong_h(0);
		ga.setLong_mmss(0);
		control = MockControl.createControl(ISeekGameService.class);
		mock = (ISeekGameService) control.getMock();
		ga.setSeekGameService(mock);
	}

	/*
	 * public void testFindByProv(){ ArrayList<PuzzleSolvingGameInfo> ret = new
	 * ArrayList<PuzzleSolvingGameInfo>(); control.reset();
	 * control.expectAndReturn(mock.seekByProv("JiangSu"),ret);
	 * control.replay(); assertEquals(ga.findByProv(),"success"); }
	 */
	/*
	 * public void testFindByCou(){ ArrayList<PuzzleSolvingGameInfo> ret = new
	 * ArrayList<PuzzleSolvingGameInfo>(); control.reset();
	 * control.expectAndReturn(mock.seekByCou("China"),ret); control.replay();
	 * assertEquals(ga.findByCou(),"success"); }
	 */
	public void testFindByOriginLatLong() {
		ArrayList<PuzzleSolvingGameInfo> ret = new ArrayList<PuzzleSolvingGameInfo>();
		control.reset();
		control.expectAndReturn(mock.seekByArea(0.0, 0.0, 0.0), ret);
		control.replay();
		ga.setOrigin_lat(0.0);
		ga.setOrigin_long(0.0);
		ga.setRadius2(0.0);
		assertEquals(ga.findByOriginLatLong(), "success");
	}

	public void testFindByLatLong() {
		ArrayList<PuzzleSolvingGameInfo> ret = new ArrayList<PuzzleSolvingGameInfo>();
		control.reset();
		control.expectAndReturn(mock.seekByArea(0.0, 0.0, 0.0), ret);
		control.replay();
		ga.setLat_h(0);
		ga.setLong_h(0);
		ga.setLat_mmss(0.0);
		ga.setLong_mmss(0.0);
		ga.setLat_ns(0);
		ga.setLong_ew(0);
		ga.setRadius2(0.0);
		assertEquals(ga.findByLatLong(), "success");
	}

	public void tearDown() {
		control.verify();
	}

}
