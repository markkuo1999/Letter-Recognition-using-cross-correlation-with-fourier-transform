Scene = imread('./Scene.bmp');
Letter_e = imread('./letter_e.bmp');
Scene = rgb2gray(Scene);
Letter_e = rgb2gray(Letter_e);

tic
crr = xcorr2(Scene, Letter_e);
toc
