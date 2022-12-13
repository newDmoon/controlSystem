package com.dnoviy.controlSystem.service;

import com.dnoviy.controlSystem.entity.EGoodType;
import com.dnoviy.controlSystem.entity.EQuality;
import com.dnoviy.controlSystem.entity.User;
import com.dnoviy.controlSystem.pojo.GoodForCountAnalyse;
import com.dnoviy.controlSystem.repository.CompanyRepository;
import com.dnoviy.controlSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DashboardServiceImpl implements DashboardService {
    private final UserRepository userRepository;

    public DashboardServiceImpl(UserRepository userRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
    }

    public ArrayList<GoodForCountAnalyse> getPerfectGoods() {
        ArrayList<GoodForCountAnalyse> goodForCountAnalyse = new ArrayList<>();
        CurrentUserInfoService currentUserInfoService = new CurrentUserInfoService();
        User user = userRepository.findByUsername(currentUserInfoService.getCurrentUsername()).get();
        AtomicInteger allCount = new AtomicInteger();
        if (user.getCompany().getGoods() != null) {
            user.getCompany().getGoods().forEach(good -> {
                if (good.getStock() != null) {
                    allCount.addAndGet(good.getStock());
                    if (good.getQuality().equals(EQuality.QUALITY_PERFECT)) {
                        if (good.getName() != null) {
                            goodForCountAnalyse.add(new GoodForCountAnalyse(good.getName(), good.getStock()));
                        }
                    }
                }
            });
        }
        goodForCountAnalyse.forEach(goodForCountAnalyse1 -> {
            goodForCountAnalyse1.setPercentFromAll(((float) goodForCountAnalyse1.getCountOfGoods() / (float) allCount.get() * 100));
        });
        return goodForCountAnalyse;
    }

    public Map<EGoodType, AtomicInteger> getImportExport() {
        CurrentUserInfoService currentUserInfoService = new CurrentUserInfoService();
        User user = userRepository.findByUsername(currentUserInfoService.getCurrentUsername()).get();
        Map<EGoodType, AtomicInteger> mapCount = new HashMap<>();
        AtomicInteger importGoods = new AtomicInteger();
        AtomicInteger exportGoods = new AtomicInteger();
        if (user.getCompany().getGoods() != null) {
            user.getCompany().getGoods().forEach(good -> {
                if (good.getGoodType() != null) {
                    if(good.getGoodType().equals(EGoodType.TYPE_EXPORT)){
                        exportGoods.addAndGet(good.getStock());
                    } else {
                        importGoods.addAndGet(good.getStock());
                    }
                }
            });
        }
        mapCount.put(EGoodType.TYPE_EXPORT, exportGoods);
        mapCount.put(EGoodType.TYPE_IMPORT, importGoods);
        return mapCount;
    }



//    @Override
//    public ArrayList<DocumentsForCountAnalyse> getUserDocumentsCount() {
//        List<User> userList = userRepository.findAll();
//        Map<String, Integer> documentsCount = new HashMap<>();
//        ArrayList<DocumentsForCountAnalyse> documentsForCountAnalyses = new ArrayList<>();
//        int allDocsCount = 0;
//        for (User user : userList) {
//            if (user.getDocuments() != null) {
//                documentsCount.put(user.getUsername(), user.getDocuments().size());
//                allDocsCount += user.getDocuments().size();
//            } else {
//                documentsCount.put(user.getUsername(), 0);
//            }
//        }
//        final Float all = (float) allDocsCount;
//        if (documentsCount.size() > 5) {
//            List<Map.Entry<String, Integer>> list = documentsCount.entrySet().stream()
//                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                    .limit(5)
//                    .collect(Collectors.toList());
//            list
//                    .forEach(document -> {
//                        Float percent = document.getValue() / all * 100;
//                        documentsForCountAnalyses
//                                .add(new DocumentsForCountAnalyse(
//                                        document.getKey(), document.getValue(), percent));
//                    });
//        } else {
//            documentsCount.entrySet().stream()
//                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                    .collect(Collectors.toList())
//                    .forEach(document -> {
//                                Float percent = document.getValue() / all * 100;
//                                documentsForCountAnalyses
//                                        .add(new DocumentsForCountAnalyse(
//                                                document.getKey(), document.getValue(), percent));
//                            }
//                    );
//        }
//        return documentsForCountAnalyses;
//    }
//
//    @Override
//    public Map<String, Integer> getUserSubscribersCount() {
//        List<User> userList = userRepository.findAll();
//        Map<String, Integer> subscribersCount = new TreeMap<>();
//        for (User user : userList) {
//            if (user.getSubscribers().size() != 0) {
//                subscribersCount.put(user.getUsername(), user.getSubscribers().size());
//            }
//        }
//        return subscribersCount;
//    }
//
//    @Override
//    public Map<String, Float> getUserDocumentsSizeCount() {
//        List<User> userList = userRepository.findAll();
//        Map<String, Float> documentsCount = new HashMap<>();
//        for (User user : userList) {
//            if (user.getDocuments() != null) {
//                float userDocsSize = 0;
//                for (Document document : user.getDocuments()) {
//                    userDocsSize += document.getSize();
//                }
//                if (userDocsSize != 0) {
//                    documentsCount.put(user.getUsername(), userDocsSize);
//                }
//            }
//            if (documentsCount.size() == 5) {
//                return documentsCount;
//            }
//        }
//        return documentsCount;
//    }
}
