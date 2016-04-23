function expMax

% EXPECTATION-MAXIMIZATION ALGORITHM WITH
% TWO GAUSSIAN COMPONENTS.

% GET DATA VECTOR (x)
x = MakeData;

N = length(x);

K = 2;   % NUMBER OF COMPONENTS

% INITIALIZE EM ALGORITHM

Xmean = [1 2];
Xstd = [7 1];
Pk = [0.4 0.6];

binwidth = 0.5;
bins = (-20:binwidth:20)';
n = hist(x,bins);
n = n/N/binwidth;

LW = 2;

for iter = 1:15
    
    figure(2)
    clf
    h = bar(bins,n,1);
    set(h,'FaceColor','w');
    px = zeros(size(bins));
    for k = 1:K    
        pk = Pk(k)/sqrt(2*pi)/Xstd(k)*exp(-(bins-Xmean(k)).^2/(2*Xstd(k)^2));
        px = px + pk;
        hold on
        ha1 = plot(bins,pk,'r', 'linewidth', LW);
    end
    hax = plot(bins,px,'blue', 'linewidth', LW);
    legend([ hax, ha1 ] , 'Total density', 'Components')
    s = sprintf('EM ALGORITHM : ITERATION %d',iter);
    title(s);
    xlim(bins([1 end]))
    ylim([0 1.3*max(n)])
    
    
    orient landscape
%     if iter == 1
%         print -dpsc expMax
%     else
%         print -append -dpsc expMax
%     end
    
    drawnow
    % disp('I am pausing for you to press a key.')
    % pause
    
    
    % E-STEP
    
    p1 = Pk(1)/sqrt(2*pi)/Xstd(1)*exp(-(x-Xmean(1)).^2/(2*Xstd(1)^2));
    p2 = Pk(2)/sqrt(2*pi)/Xstd(2)*exp(-(x-Xmean(2)).^2/(2*Xstd(2)^2));
    Px = p1 + p2;
    pkn = [p1./Px p2./Px];
    
    % M-STEP
    
    Pk = sum(pkn)/N;
    
    for k = 1:2
        Xmean(k) = sum(pkn(:,k).*x)/sum(pkn(:,k));
        Xstd(k) = sqrt(sum(pkn(:,k).*(x-Xmean(k)).^2)/sum(pkn(:,k)));
    end
    
    fprintf('Iteration %d\n',iter);
    fprintf('Xmean = %f\t%f\n',Xmean(1),Xmean(2));
    fprintf('Xstd = %f\t%f\n',Xstd(1),Xstd(2));
    fprintf('p(1) = %f, p(2) = %f\n\n',Pk(1),Pk(2));
end


% --- LOCAL FUNCTION ---

function x = MakeData

Xmean = [-2 4];  % MEANS OF GAUSSIANS
Xstd = [1 4];    % STANDARD DEVIATIONS
p = [0.6 0.4];   % MIXTURE PARAMETERS
p = p/sum(p);    % (Must add to 1.)

K = length(p);   % NUMBER OF COMPONENTS

N = 1000;       % NUMBER OF DATA POINTS

% GENERATE RANDOM DATA
x = [];
for k = 1:K
    x = [x; Xmean(k) + Xstd(k)*randn(round(p(k)*N),1)];
end

% DISPLAY HISTOGRAM
binwidth = 0.5;
bins = [-20:binwidth:20]';
n = hist(x,bins);
n = n/N/binwidth;

figure(1)
clf
h = bar(bins,n,1);
set(h,'FaceColor','w');

LW = 2;

px = zeros(size(bins));
for k = 1:K    
    pk = p(k)/sqrt(2*pi)/Xstd(k)*exp(-(bins-Xmean(k)).^2/(2*Xstd(k)^2));
    px = px + pk;
    hold on
    ha1 = plot(bins,pk,'r', 'linewidth', LW);
end
hax = plot(bins,px,'blue', 'linewidth', LW);
title('TRUE DISTRIBUTION AND HISTOGRAM');

legend([ hax, ha1 ] , 'Total density', 'Components');

xlim(bins([1 end]))
ylim([0 1.3*max(n)])

% orient landscape   
% print -dpsc expMax
