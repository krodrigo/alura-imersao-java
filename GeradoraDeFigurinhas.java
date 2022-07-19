import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
  public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

    BufferedImage imagemOriginal = ImageIO.read(inputStream);

    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);

    setTextCenter(graphics, "TOPZERA", novaImagem);
    graphics.dispose();

    File directory = new File("output");
    if (!directory.exists()) {
      directory.mkdir();
    }

    ImageIO.write(novaImagem, "png", new File("output/" + nomeArquivo));
  }

  private static void setTextCenter(Graphics2D image, String text,
      BufferedImage bgImage) throws Exception {

    InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("fonts/impact.ttf");
    Font fonte = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(64f);

    image.setColor(Color.YELLOW);
    image.setFont(fonte);

    int stringWidthLength = (int) image.getFontMetrics().getStringBounds(text, image).getWidth();

    int horizontalPosition = bgImage.getWidth() / 2 - stringWidthLength / 2;
    int verticalPosition = bgImage.getHeight() - 100;

    image.drawString(text, horizontalPosition, verticalPosition);
  }
}
