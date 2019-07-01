package FlowerShopServiceImpl;


/**
 * 创造新的鲜花
 */
public Flower Newflower (String[] fParam){
		Flower flower = new Flower();
		Flower.setfId(fParam[0]);
		Flower.setfName(fParam[1]);
		Flower.setfType(fParam[2]);
		Flower.setfPrice(fParam[3]);
		Flower.setfNum(fParam[4]);
		Flower.setfUpTime(fParam[5]);
		return flower;
	}
